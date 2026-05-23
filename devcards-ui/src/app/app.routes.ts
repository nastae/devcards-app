import { Routes } from '@angular/router';
import { StudyPage } from './features/study/pages/study-page/study-page';
import { FeedbackPage } from './features/feedback/pages/feedback-page/feedback-page';

export const routes: Routes = [
    {
        path: 'study',
        component: StudyPage
    },
    {
        path: 'feedback',
        component: FeedbackPage
    },
    {
        path: '',
        redirectTo: 'study',
        pathMatch: 'full'
    }
];
