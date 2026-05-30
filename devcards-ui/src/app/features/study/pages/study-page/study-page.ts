import { Component, inject, OnInit, signal } from '@angular/core';
import { MatAnchor } from "@angular/material/button";
import { StudyService } from '../../services/study-service';
import { FlashcardResponse } from '../../models/flashcard-response';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { provideAnimations } from '@angular/platform-browser/animations';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-study-page',
  imports: [MatAnchor, MatProgressSpinnerModule, MatProgressBarModule],
  templateUrl: './study-page.html',
  styleUrl: './study-page.scss',
})
export class StudyPage implements OnInit {

  // TODO: convert flashcards → signal (optionally)
  flashcards: FlashcardResponse[] = [];
  currentIndex = 0;
  flipped = false;
  // TODO: replace with flashcards.length > 0
  started = false;

  // loading = false;
  loading = signal(false);

  private readonly studyService = inject(StudyService);
  private readonly router = inject(Router);

  ngOnInit(): void {

  }

  startLearning() {
    // this.started = true;
    this.loadFlashcards();
  }

  // TODO: handle error properly
  loadFlashcards(): void {
    this.loading.set(true);

    this.studyService.getTodayFlashcards().subscribe({
      next: (data) => {
        this.flashcards = data;
        this.currentIndex = 0;
        this.flipped = false;
        this.loading.set(false);
        this.started = true;
      },
      error: (err) => {
        console.log(err);
        this.loading.set(false);
      }
    });
  }

  // TODO: convert to computed, derived state
  get currentCard(): FlashcardResponse | null {
    return this.flashcards.length > 0
      ? this.flashcards[this.currentIndex]
      : null;
  }

  progress(): number {
    return this.flashcards.length
      ? (this.currentIndex / this.flashcards.length) * 100
      : 0;
  }

  flipCard() {
    this.flipped = !this.flipped;
  }

  // TODO: if last item, nagivate to study page
  next() {
    if (!this.isLastCard) {
      this.currentIndex++;
      this.flipped = false;
    } else {
      this.resetState();
      this.router.navigate(['/study']);
    }
  }

  previous() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
      this.flipped = false;
    }
  }

  // TODO: convert to computed, derived state
  get isLastCard(): boolean {
    return this.flashcards?.length
      ? this.currentIndex === this.flashcards.length - 1
      : false;
  }

  easy() {
    // this.currentIndex += 2; // skip ahead UX
    // if (this.currentIndex >= this.flashcards.length) {
    //   this.currentIndex = this.flashcards.length - 1;
    // }
    // this.flipped = false;
    this.next();
  }

  good() {
    this.next();
  }

  hard() {
    this.next();
  }

  again() {
    // const card = this.flashcards.splice(this.currentIndex, 1)[0];
    // this.flashcards.push(card);
    // this.flipped = false;
    this.next();
  }

  private resetState() {
    this.started = false;
    this.loading.set(false);
    this.flashcards = [];
    this.currentIndex = 0;
    this.flipped = false;
  }
}
