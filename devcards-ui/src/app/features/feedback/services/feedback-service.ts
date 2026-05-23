import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { FeedbackRequest } from '../models/feedback-request';
import { FeedbackResponse } from '../models/feedback-response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FeedbackService {

  private http = inject(HttpClient);

  private apiUrl = '/api/feedback';

  sendFeedback(request: FeedbackRequest): Observable<FeedbackResponse> {
    // return this.http.post<FeedbackResponse>(this.apiUrl, request);
    return this.http.post<FeedbackResponse>('http://localhost:8080/api/feedback', request);
  }
}
