# Krótka ściąga ułatwiająca pracę z Gitem

Z Gita można korzystać bezpośrednio z wiersza poleceń, ale wiele IDE posiada wbudowane wtyczki obsługujące Gita, co dodatkowo ułatwia pracę z repozytorium.

Aby pobrać projekt, użyj komendy:

```bash
git clone https://github.com/Gadomskyy/shortestPathAlgorithmsProject.git
```

lub skorzystaj z odpowiedniej opcji w swoim IDE, jeśli taką posiada.

---

## Workflow pracy nad projektem po sklonowaniu repozytorium

1. **Przed rozpoczęciem pracy** użyj `git pull` na branchu `main`, aby pobrać najświeższą wersję repozytorium.
2. **Upewnij się, że reszta zespołu jest na bieżąco** ze stanem projektu i tym, nad czym pracujesz – pozwoli to uniknąć duplikowania pracy i konfliktów przy mergowaniu.
3. **Stwórz nowego brancha**, na którym będziesz pracować i wprowadzać zmiany/dodawać nowe funkcjonalności.  
   Sukcesywnie commituj swój progres, używając zwięzłych, ale klarownych komunikatów commitów.
4. **Gdy chcesz zmergować swoje zmiany do głównego brancha**, użyj `git push`, aby wypchnąć swojego brancha na GitHuba.  
   Spowoduje to utworzenie pull requesta (PR).
5. **Poproś o review** jednego z członków projektu. Jeśli pojawią się uwagi, przedyskutujcie je i wprowadźcie potrzebne poprawki.
6. **Zamknij pull request dopiero po review** od innego członka projektu.
7. GitHub automatycznie usunie zmergowanego brancha.  
   Przejdź do lokalnego repozytorium, zmień brancha na `main`, pobierz najnowszą wersję poleceniem `git pull` i usuń lokalnego brancha, aby utrzymać porządek.

---

W **99% przypadków** stosowanie powyższego workflow wystarczy do sprawnej pracy nad wspólnym projektem.  
W przypadku komplikacji będziemy je rozwiązywać na bieżąco.
