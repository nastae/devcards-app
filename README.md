### Improvements:
1. Use spaced repetition logic on StudyService getTodayFlashcards instead of random falshcards
2. “anonymous feedback” flag (feedback page)
3. emoji rating (😡 😐 🙂 😍) (feedback page)
4. Real spaced repetition algorithm (SM-2 like Anki)
5. Swipe gestures (left/right instead of buttons)
6. Sound + haptic feedback
7. “Mastered” deck removal system
8. Full-screen study mode (no distractions) (optional)


### local build and run image

devcards-service:
```
docker build -t devcards-service .
docker run -p 8080:8080 devcards-service
```

