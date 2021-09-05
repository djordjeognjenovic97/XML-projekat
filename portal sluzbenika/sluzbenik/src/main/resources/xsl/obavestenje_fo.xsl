<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:oba="https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir"
        version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="obavestenjeStranica" page-height="29.7cm" page-width="21cm"
                        margin-top="1cm" margin-bottom="2cm" margin-left="2.5cm"
                        margin-right="2.5cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm" />
                    <fo:region-before extent="2cm" />
                    <fo:region-after extent="2cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="obavestenjeStranica">
                <fo:flow flow-name="xsl-region-body" font-size="12px"
                         text-align="justify">
                            <fo:block font-size="12px" text-decoration="underline">
                                <xsl:value-of select="/oba:obavestenje/oba:organ/oba:naziv_organa"/>
                            </fo:block>
                            <fo:block font-size="12px" text-decoration="underline">
                                <xsl:value-of select="/oba:obavestenje/oba:organ/oba:sediste_organa"/>
                            </fo:block>
                            <fo:block font-size="10px">
                                (naziv i sedište organa)
                            </fo:block>
                            <fo:block font-size="12px" >
                                Broj predmeta:<xsl:value-of select="/oba:obavestenje/oba:broj_predmeta"/>
                            </fo:block>
                            <fo:block font-size="12px">
                                Datum: <xsl:value-of select="/oba:obavestenje/oba:datum"/>
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-decoration="underline">
                                <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:ime"/>&#160;
                                    <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:prezime"/>
                            </fo:block>
                            <fo:block font-size="12px" text-decoration="underline">
                                <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:mesto"/>,
                                    <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:ulica"/>&#160;
                                    <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:br_ulice"/>
                            </fo:block>
                            <fo:block font-size="12px">
                                Ime i prezime / naziv / i adresa podnosioca zahteva
                            </fo:block>
                            <fo:block text-align="center" padding-top="20px" font-weight="bold" font-size="15px">
                                O B A V E Š T E NJ E
                            </fo:block>
                            <fo:block text-align="center" font-size="16px">
                                <xsl:value-of select="/oba:obavestenje/oba:naslov"/>
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-align="justify"  >
                                Na osnovu člana 16. st. 1. Zakona o slobodnom pristupu informacijama od javnog značaja
                                postupajući po vašem zahtevu za slobodan pristup informacijama od
                                <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:datum_uvida"/> god., kojim
                                ste tražili uvid u dokument/e sa informacijama o / u vezi sa:
                            </fo:block>
                            <fo:block font-size="12px" padding-left="15px" padding-top="5px" text-align="justify" text-decoration="underline">
                                <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:opis_trazene_informacije"/>
                            </fo:block>
                            <fo:block font-size="11px" padding-top="px" text-align="center" >
                                (opis tražene informacije)
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-align="justify"  >
                                obaveštavamo vas da dana <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:datum_uvida"/>
                                , u <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:broj_sati"/> časova,
                                odnosno u vremenu od <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:pocetak_akcije"/>
                                do <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:kraj_akcije"/> časova,
                                u prostorijama organa u <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:mesto"/>
                                ul. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:ulica"/>
                                br. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:br_ulice"/>,
                                kancelarija br. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:broj_kancelarije"/> možete izvršiti
                                uvid u dokument/e u kome je sadržana tražena informacija.
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-align="justify"  >
                                Tom prilikom, na vaš zahtev, može vam se izdati i kopija dokumenta sa traženom informacijom.
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-align="justify"  >
                                Troškovi su utvrđeni Uredbom Vlade Republike Srbije („Sl. glasnik RS“, br. 8/06), i to:
                                kopija strane A4 formata iznosi 3 dinara, A3 formata 6 dinara, CD 35 dinara, diskete 20
                                dinara, DVD 40 dinara, audio-kaseta – 150 dinara, video-kaseta 300 dinara, pretvaranje
                                jedne strane dokumenta iz fizičkog u elektronski oblik – 30 dinara.
                            </fo:block>
                            <fo:block font-size="12px" padding-top="15px" text-align="justify"  >
                                Iznos ukupnih troškova izrade kopije dokumenta po vašem zahtevu
                                iznosi <xsl:value-of select="/oba:obavestenje/oba:iznos_troskova"/> dinara i uplaćuje se
                                na žiro-račun Budžeta Republike Srbije br. 840-742328-843-30, s pozivom na broj 97 – oznaka
                                šifre opštine/grada gde se nalazi organ vlasti (iz Pravilnika o uslovima i načinu
                                vođenja računa – „Sl. glasnik RS“, 20/07... 40/10).
                            </fo:block>
                            <fo:block padding-top="10px">
                                <fo:inline-container inline-progression-dimension="50%">
                                    <fo:block font-size="12px">
                                        Dostavljeno
                                    </fo:block>
                                        <xsl:if test="/oba:obavestenje/oba:dostavljeno/oba:opcija_dostave/oba:naziv='imenovanom'">
                                            <fo:block font-size="12px" text-decoration="underline">
                                            1.   Imenovanom  (M.P)
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="not(/oba:obavestenje/oba:dostavljeno/oba:opcija_dostave/oba:naziv='imenovanom')">
                                            <fo:block font-size="12px">
                                                1.   Imenovanom  (M.P)
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="/oba:obavestenje/oba:dostavljeno/oba:opcija_dostave/oba:naziv='arhivi'">
                                            <fo:block font-size="12px" text-decoration="underline">
                                            2.   Arhivi
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="not(/oba:obavestenje/oba:dostavljeno/oba:opcija_dostave/oba:naziv='arhivi')">
                                            <fo:block font-size="12px">
                                                2.   Arhivi
                                            </fo:block>
                                        </xsl:if>
                                </fo:inline-container>
                                <fo:inline-container inline-progression-dimension="50%" text-align="center">
                                    <fo:block font-size="12px">
                                        _______________________
                                    </fo:block>
                                    <fo:block font-size="11px">
                                        (potpis ovlašćenog lica, odnosno rukovodioca organa)
                                    </fo:block>
                                </fo:inline-container>
                            </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>