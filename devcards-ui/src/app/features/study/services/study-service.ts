import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FlashcardResponse } from '../models/flashcard-response';
import { environments } from '../../../../environments/environments';

@Injectable({
  providedIn: 'root',
})
export class StudyService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl = "/study";

  getTodayFlashcards(): Observable<FlashcardResponse[]> {
    return this.http.get<FlashcardResponse[]>(environments.apiUrl + this.apiUrl);
  }
}
