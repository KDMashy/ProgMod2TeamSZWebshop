# ProgMod2 Projekt: Számítás Technikai Webshop

## Koncepció

Egy átlagos, számítás technikai eszközöket áruló weboldal lesz, nagyjából egyszerű elrendezéssel
és könnyű kezelésre alkalmas UI-al
Viszonylag UX központú

## Design terv

![HomePage](https://github.com/KDMashy/ProgMod2TeamSZWebshop/blob/main/Design/HomePage.PNG)

* HomePage
    * Egy mainen belül találhatóak a kiemelt termékek, hírek
    * Nav
        * A bal szélén található majd a logónk
        * Középreigazítva, logótól és egyébtől bizonyos távolságra lesznek a menü gombok
        * A jobb oldalon található itt a kosár, és a felhasználói bejelentkezés
    * Footer
        * Egyéb információk minden oldalon

![ShopPage](https://github.com/KDMashy/ProgMod2TeamSZWebshop/blob/main/Design/ShopPage.PNG)

* ShopPage
    * Nav rész megegyezik
    * Footer rész megegyezik
    * Bal szélen, Aside
        * Kategóriák, szűrés
    * Jobb oldalon, Main
        * Termékek

## Nyelv, osztályok, változók (felépítés) illetve tervek a fejlesztésre

GitHub/Gitlab Használata
WebApplication lesz a projekt/"webshop"
A kód Java nyelven fog íródni
Programok amik használva lesznek:
* NetBeans 8.2 (Backend - Java)
* MySQL Workbench (még nem, de ezen fogunk tanulni is elvileg, illetve még eldönti pontosan a DB-Dev)
* Brackets/VSCode (Frontend - HTML5/CSS/JS)

# Adat struktúra

![ER Diagram](https://github.com/KDMashy/ProgMod2TeamSZWebshop/blob/main/ER-UML/ERDia.png)

* Termék
    * Név - egyedi
    * leírás
    * kép - több lehet
    * ár
    * készleten - számolt
* Partner
    * Adószám - egyedi
    * Partnernév
    * Elérhetőség - több lehet
    * Kapcsolat
    * beszerzés
        * Egységár
        * Mennyiség
        * Számla
        * Beszerzés Dátuma
* Vevő
    * VevőID - egyedi
    * Név
    * Számlázási Cím
    * Cégnév
    * Adószám
    * Törzsvásárló
    * Vásárlás
        * Vásárlás Dátuma
        * Számla
        * Fizetési mód
        * Sorszám - egyedi
        * Mennyiség
        * Egységár
* Szervíz
    * Szervíznév
    * Elérhetőség
* Gyártó
    * Név
    * Weboldal/Elérhetőség
    * Gyártói Garancia
    * GyártóID
* Kategória
    * Alkategória
        * AlkategóriaNév
    * Kategória
        * KategóriaNév

# UML Class Diagram

![Class Diagram](https://github.com/KDMashy/ProgMod2TeamSZWebshop/blob/main/ER-UML/WebShopClassDiaEredetiJavított.drawio.png)

Minden Private, ami public/protected, jelezve van

* Vevő
    * VID - protected
    * Vname : String
    * VPassword : String
    * Cím : String
    * CegNev : String
    * VAdoSzam: Integer
    * TörzsVasarlo : Boolean

Rendelkezik Register és Login Felülettel, Login után külön Admin login teszi elérhetővé az Admin felületet
Adatait csak a profilján, adott személy kérheti le, kivéve VID

* Admin
    * AdminPassw : String
    * AdminName : String
    * AdminCode : String

Külön admin loginon kell jelszó és kód is az adminnak, ő kérheti le a megrendelések adatait, illetve regisztrálhatja azokat

* Partner
    * PartnerName : String
    * Adoszam : Integer
    * PElerhetoseg : String (több lehet)
    * Kapcsolat : String (Több lehet)
    * Beszerzes - protected
        * bAr : Integer
        * bAmount : Integer
        * bSzamla : Boolean
        * bDate : String

Partner egyedet létrehozni csak admin tud

* Gyarto
    * GyartoID - protected
    * GyartoName : String
    * Website : String (lényegében elérhetőség is)
    * GyartoiGarancia : Boolean (Vállalnak e)

Gyártó egyedet csak admin hozhat létre

* Termek
    * img : String (több egyed, elérést adunk meg a képekhez)
    * Name : String
    * Description : String
    * Stock : Boolean
    * ID - protected

Termék egyedet admin hozhat létre

* Szerviz
    * szervizName : String
    * SzElerhetoseg : String

Szervíz egyedet admin hozhat létre

* Kategória
    * KatID - protected
    * KategoriaName : String
    * AlKategoriaName : String

Nemhozhatja létre semmi, egyedei meghatározottak, termékek szüűrésére használjuk

* Vasarlas
    * fizetesiMod : String
    * szamla : Boolean
    * eladasiDate: String
    * amount : Integer
    * sorszam : Integer
    * egysegAr : Integer

Egy vásárlást csak vevő, vagy nagyobb ranggal rendelkező indíthat, ehhez be kell jelentkezni

> Koncepciót készítette:
    Elemző:                     Tóth Kelemen
    Frontend,Design:            Benkő Kaba
    Backend,DB(ERDia)           Till Krisztián
    Backend,Fejlesztő(ClassDia) Klepe Dominik
    Tesztelő                    Heindl Jakab