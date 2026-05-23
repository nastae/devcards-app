import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAnchor } from "@angular/material/button";
import { FeedbackService } from '../../services/feedback-service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-feedback-page',
  imports: [MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatAnchor],
  templateUrl: './feedback-page.html',
  styleUrl: './feedback-page.scss',
})
export class FeedbackPage {

  private feedbackService = inject(FeedbackService);
  private snackBar = inject(MatSnackBar);
  
  form = new FormGroup({
    message: new FormControl('', {
      nonNullable: true,
      validators: [
      Validators.required,
      Validators.minLength(5)
    ]})
  });

  submit() {
    if (this.form.invalid) {
      return;
    }

    const request = this.form.getRawValue();

    this.feedbackService.sendFeedback(request).subscribe({
      next: () => {
        this.snackBar.open('Thanks for feedback 💬', 'Close', {
          duration: 2000
        });

        this.form.reset();
        this.form.markAsPristine();
        this.form.markAsUntouched();
      },
      error: () => {
        this.snackBar.open('Error sending feedback ❌', 'Close', {
          duration: 2000
        })
      }
    });
  }
}
