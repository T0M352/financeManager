System do zarządzania finansami zainspirowany prostą działalnością znajomego polegającą na pośrednictwie w sprzedaży częsci samochodowych z 3 % marżą od której musi odprowadzić 19% podatku dochodowego. Aplikacja umożliwia zarządzanie takiego typu działalnością. Połączyłem ją z zewnętrzną bazą danych i tam przechowuje liste produktów. 
Interfejs dla użytkownika zrealizowany jest za pomocą thymeleaf oraz prostych stron html. Aplikacja pozwala na wyświetlanie listy produktów, dodawanie nowych produktów, edycje produktów, usuwanie ich. Ponadto daje użytkownikowi możliwość wyświetlania produktów zakupionych w danym okresie czasu, oraz wyświetlanie statystyk takich jak przychod czy obrót dla danego okresu czasu.
Plik wykonywalny w folderze target 
aplikacja webowa dziala na lokalnym hoscie na porcie 8080

aby exec odpowiednio sie zbudowal trzeba uzyc mvnw clean package