import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FlashcardResponse } from '../models/flashcard-response';

@Injectable({
  providedIn: 'root',
})
export class StudyService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl = "/api/study";

  getTodayFlashcards(): Observable<FlashcardResponse[]> {
    return this.http.get<FlashcardResponse[]>(this.apiUrl);
  }
}
