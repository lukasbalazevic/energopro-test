# **Solution Design Document (SDD)**

## **1. Úvod**

### **1.1 Cieľ dokumentu**

Tento dokument popisuje návrh riešenia pre Sales aplikáciu (Android [Tablet]) a Customer Care aplikácie (Android & iOS). Dokument sa sústreďuje na minimálne verzie aplikácií a pokrýva ich architektúru, funkčné požiadavky, ne-funkčné požiadavky a návrh integrácií s externými systémami.

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

✅ **Frontend:**

- **Sales aplikácia** je natívna Android aplikácia napísaná v **Kotlin**, ktorá ale zdieľa **network modul v KMM** so **Customer Care aplikáciou**.
- **Customer Care aplikácia** je **KMP projekt**, kde je Android a iOS verzia vyvíjaná v **Kotlin Multiplatform Mobile (KMM)**.

## **3. Architektúra systému**

Diagram obsahujúci odhady, scope a nacenenie bude doplnený. Na základe neho budú vytvorené epiky.

---

## **4. Business prehlad**

### **4.1 Sales aplikácia**

| Funkcionalita      | Popis                           | Epika                | Riziko (MD) | Android |
| ------------------ | ------------------------------- | -------------------- | ----------- | ------- |
| Založení projektu  | Nastavenie repozitára, CI/CD    | Nefunkčné požiadavky | -           | 5       |
| Networking         | Autentifikácia, tokeny          | Nefunkčné požiadavky | -           | 10      |
| Internacionalizace | Jazyková podpora                | Nefunkčné požiadavky | -           | 3       |
| Contracts Overview | Prehľad kontraktov              | Contracts Overview   | -           | 12      |
| Scan ID            | Skenovanie občianskeho preukazu | Scan ID              | -           | 10      |

### **4.2 Customer Care aplikácia - Fáza 1**

| Funkcionalita          | Popis                     | Epika                | Riziko (MD) | KMP | Android | iOS |
| ---------------------- | ------------------------- | -------------------- | ----------- | --- | ------- | --- |
| Založení projektu      | Nastavenie repozitára     | Nefunkčné požiadavky | -           | 4   | 1       | 1   |
| Internacionalizace     | Jazyková podpora          | Nefunkčné požiadavky | -           | 3   | 1       | 1   |
| Dark mode              | Podpora tmavého režimu    | Nefunkčné požiadavky | -           | 0   | 2       | 2   |
| Profile - zmena údajov | Úprava profilových údajov | Profile              | -           | 2   | 2       | 2   |

### **4.3 Customer Care aplikácia - Fáza 2**

| Funkcionalita      | Popis                          | Epika      | Riziko (MD) | KMP | Android | iOS |
| ------------------ | ------------------------------ | ---------- | ----------- | --- | ------- | --- |
| Design system      | Rozšírenie dizajnového systému | Design     | -           | 0   | 7       | 7   |
| Consumption Graphs | Zobrazenie spotreby            | Graphs     | -           | 2   | 8       | 8   |
| Self-Read          | Samoodpočet                    | POD detail | -           | 3   | 15      | 15  |
| Share POD          | Zdieľanie odberného miesta     | POD detail | -           | 3   | 7       | 7   |
| Activities         | História aktivít               | Activities | -           | 5   | 7       | 7   |
| Requests           | Podávanie požiadaviek          | Requests   | -           | 5   | 5       | 5   |

Tieto epiky sú odvodené na základe dodaných odhadov a sú zaradené podľa dôležitosti a plánovania do fáz vývoja aplikácie.

