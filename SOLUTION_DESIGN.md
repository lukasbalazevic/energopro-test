
# **Solution Design Document (SDD)**

## **1. Úvod**

### **1.1 Cieľ dokumentu**

Tento dokument popisuje návrh riešenia pre Sales aplikáciu (Android [Tablet]) a Customer Care aplikácie (Android & iOS). Dokument sa sústreďuje na ich architektúru, funkčné požiadavky, ne-funkčné požiadavky a návrh integrácií s externými systémami.

### **1.2 Rozsah riešenia**

Riešenie pokrýva:

- **Sales aplikáciu** pre Android, ktorá slúži na kontraktovanie zákazníkov a správu zákazníckych údajov.
- **Customer Care aplikácie** pre Android a iOS, ktoré umožnia zákazníkom správu ich účtov, faktúr a zákazníckych požiadaviek.

### **1.3 Cieľové publikum**

Dokument je určený pre:

- Vývojový tím
- IT architektov a analytikov

### **1.4 Skratky a definície**

- **POD** – Point of Delivery (odberné miesto)
- **BO** – Back Office
- **OTP** – One Time Password
- **DSS** – Digital Signature Service
- **MDM** – Mobile Device Management
- **SSO** – Single Sign-On

## **2. Prehľad riešenia**

### **2.1 Stručný popis aplikácií**

- **Sales aplikácia (Android)** bude primárne používaná obchodnými zástupcami v teréne. Podporuje offline režim a umožňuje podpisovanie kontraktov priamo na mieste.
- **Customer Care aplikácie (Android & iOS)** umožnia zákazníkom spravovať svoje odberné miesta, faktúry, platby a podávať požiadavky na zákaznícku podporu.

### **2.2 Kľúčové funkcie a požiadavky**

#### **Sales aplikácia (Android)**

✅ Správa kontraktov (nové zmluvy, rekontraktácia, zmena zákazníka)\
✅ Offline režim a synchronizácia po pripojení na internet\
✅ Integrácia s OCR na skenovanie dokladov\
✅ Digitálne podpisovanie dokumentov\
✅ Validácia zákazníckych údajov (KYC, kreditná história, blacklist)\
✅ Podpora pre Energy Consultant, COK a Telesales kanály

#### **Customer Care aplikácie (Android & iOS)**

✅ Správa zákazníckych údajov (aktualizácia kontaktných údajov)\
✅ Prehľad a úhrada faktúr cez Payment Gateway\
✅ Správa odberných miest (PODs)\
✅ Podávanie žiadostí na zákaznícku podporu\
✅ Notifikácie (platby, zmeny v zmluvách, výpadky)\
✅ Dvojfaktorová autentifikácia (2FA)

### **2.3 Technologický stack**

Projekt je vyvíjaný ako **jeden Gradle projekt s Kotlin Multiplatform (KMP)**. Obsahuje **zdieľané moduly (Shared Modules)**, ktoré využívajú obe aplikácie – **Sales aplikácia a Customer Care aplikácia**.

#### **Zdieľaný modul v KMP**

Zdieľaný modul obsahuje **dva umbrella projekty**:

-   **App Sales** – Obsahuje **Network modul**, ktorý je využívaný v Sales aplikácii.

-   **App Customer Care** – Obsahuje zdieľané komponenty a základnú logiku pre Customer Care aplikáciu.


Každá aplikácia importuje svoj príslušný **umbrella projekt**. Rozdiel spočíva v tom, aké ďalšie **zdieľané moduly** sú súčasťou jednotlivých aplikácií.

#### **Architektúra aplikácií**

-   **Sales aplikácia** je **KMP projekt s natívnym Android UI**, určená pre **Android tablety**. Používa **navigáciu a ViewModely natívne v Androide** a z KMP využíva **iba Network modul**.

-   **Customer Care aplikácia** je **plne KMP aplikácia**. **Navigácia aj logika** sú implementované v KMP, natívne je len **UI pre Android a iOS**.


#### **Zdieľané moduly v KMP**

-   **Networking** – Poskytuje komunikáciu medzi aplikáciami a backendovým systémom.

-   **Dátové modely** – Obsahuje spoločné dátové štruktúry používané v oboch aplikáciách.
### **2.4 Minimálne podporované verzie**

-   **iOS**: Aplikácia bude podporovať **aktuálnu verziu iOS-u v dobe vydania mínus dve hlavné verzie**.

    -   **Predpoklad pre koniec roka 2024**: Ak bude v tom čase aktuálna verzia **iOS 18**, aplikácia bude podporovať **iOS 16 a novšie**.

-   **Android**: Aplikácia bude podporovať **aktuálnu najnovšiu verziu Android-u v dobe vydania aplikácie mínus štyri hlavné verzie**.

    -   **Predpoklad pre koniec roka 2024**: Ak bude v tom čase aktuálna verzia **Android 15**, aplikácia bude podporovať **Android 11 a novšie**.


Tieto podmienky zabezpečia kompatibilitu s väčšinou moderných zariadení a zároveň umožnia využitie nových technológií bez potreby podporovania zastaraných verzií systémov.

### **2.5 Deployment aplikácií**

#### **Customer Care aplikácie**

Customer Care aplikácie budú vydané do **oficiálnych storov Google Play a Apple App Store**, pričom budú spĺňať všetky požiadavky pre schválenie publikácie.

#### **Sales aplikácia**

Sales aplikácia na tablety nebude vydaná do oficiálnych storov. Spôsob distribúcie bude riešený cez **interný systém distribúcie**. Aplikácia bude doručovaná klientom priamo prostredníctvom **Samsung Knox Managed**.

#### **Samsung Knox Managed**

**Samsung Knox Managed** bude využitý na správu a zabezpečenie zariadení, na ktorých bude Sales aplikácia nasadená:

-   **Centralizovaná správa** – Umožňuje vzdialené nastavenie a aktualizáciu aplikácií a konfigurácií na zariadeniach.

-   **Bezpečnostné politiky** – Obmedzuje prístup k určitým aplikáciám a dátam, zabezpečuje zariadenia proti neautorizovanému prístupu.

-   **Kontrola nad aplikáciami** – Správcovia môžu povoliť alebo zakázať inštaláciu aplikácií a ich používanie.

-   **Monitorovanie v reálnom čase** – Poskytuje prehľad o stave zariadení, ich bezpečnosti a využívaní.

-   **Vzdialené ovládanie zariadení** – V prípade straty alebo odcudzenia umožňuje vzdialené uzamknutie, vymazanie alebo reset zariadenia.

-   **Automatizovaná registrácia** – Nové zariadenia je možné automaticky nastaviť a pridať do podnikovej siete bez manuálnej konfigurácie.


#### **Aktualizácie a správa**

Aktualizácie Sales aplikácie budú distribuované priamo cez **Samsung Knox Managed**, pričom používatelia dostanú push notifikácie o dostupnosti novej verzie. Tento systém taktiež zabezpečí monitoring a správu zariadení, ochranu dát a vzdialené blokovanie alebo vymazanie údajov v prípade straty alebo odcudzenia zariadenia.




## **3. Architektúra systému**

Diagram obsahujúci odhady, scope a nacenenie bude doplnený. Na základe neho budú vytvorené epiky.

---
