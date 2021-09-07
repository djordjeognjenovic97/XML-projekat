<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:oba="https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir"
        version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">

                </style>
            </head>
            <body>
                <div style="width:45%; margin:0 auto; border: 2px solid black;">
                    <div style="padding-left:15px;">
                    <p style="font-size:14px; margin: 0%">
                        <u><xsl:value-of select="/oba:obavestenje/oba:organ/oba:naziv_organa"/></u>
                    </p>
                    <p style="font-size:14px; margin: 0%">
                        <u><xsl:value-of select="/oba:obavestenje/oba:organ/oba:sediste_organa"/></u>
                    </p>
                    <p style="font-size:12px;  margin: 0%">
                        (naziv i sedište organa)
                    </p>
                    <p style="font-size:14px;  margin: 0%">
                        Broj predmeta:<u><xsl:value-of select="/oba:obavestenje/oba:broj_predmeta"/></u>
                    </p>
                    <p style="font-size:14px; margin: 0%">
                        <xsl:variable name="datum" select="/oba:obavestenje/oba:datum"/>
                        <xsl:variable name="dan" select="substring($datum,9,2)"/>
                        <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                        <xsl:variable name="godina" select="substring($datum,1,4)"/>
                        Datum: <u><xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>.</u>
                    </p>
                    <p style="font-size:14px; padding-top:15px;  margin: 0%">
                        <u><xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:ime"/>&#160;
                            <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:prezime"/></u>
                    </p>
                    <p style="font-size:14px;  margin: 0%">
                        <u><xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:mesto"/>,
                        <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:ulica"/>&#160;
                        <xsl:value-of select="/oba:obavestenje/oba:podnosilac_zahteva/oba:adresa/oba:br_ulice"/></u>
                    </p>
                    <p style="font-size:14px;  margin: 0%">
                        Ime i prezime / naziv / i adresa podnosioca zahteva
                    </p>
                    </div>
                    <h1 style="text-align:center;padding-top:15px;font-weight: bold">
                        O B A V E Š T E NJ E
                    </h1>
                    <h2 style="font-size:16px; text-align:center">
                        <xsl:value-of select="/oba:obavestenje/oba:naslov"/>
                    </h2>
                    <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                        <xsl:variable name="id" select="/oba:obavestenje/oba:broj_predmeta"/>
                        Na osnovu člana 16. st. 1. Zakona o slobodnom pristupu informacijama od javnog značaja
                        postupajući po vašem <a href="http://localhost:4200/prikaz/zahtev/{$id}">zahtevu</a> za slobodan pristup informacijama od
                        <xsl:variable name="datum" select="/oba:obavestenje/oba:datum_zahteva"/>
                        <xsl:variable name="dan" select="substring($datum,9,2)"/>
                        <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                        <xsl:variable name="godina" select="substring($datum,1,4)"/>
                        <xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>. god., kojim
                        ste tražili uvid u dokument/e sa informacijama o / u vezi sa:
                    </p>
                    <p style="font-size:14px; padding-left:15px; text-align:justify;" >
                        <u><xsl:value-of select="/oba:obavestenje/oba:uvid/oba:opis_trazene_informacije"/></u>
                    </p>
                    <p style="font-size:12px;text-align:center; padding-left:15px; padding-right:15px;" >
                        (opis tražene informacije)
                    </p>
                    <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                        obaveštavamo vas da dana
                        <xsl:variable name="datum" select="/oba:obavestenje/oba:datum"/>
                        <xsl:variable name="dan" select="substring($datum,9,2)"/>
                        <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                        <xsl:variable name="godina" select="substring($datum,1,4)"/>
                        <xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>.
                        , u <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:broj_sati"/> časova,
                        odnosno u vremenu od
                        <xsl:variable name="pasati" select="/oba:obavestenje/oba:uvid/oba:pocetak_akcije"/>
                        <xsl:variable name="pa" select="substring($pasati,1,5)"/>
                        <xsl:value-of select="$pa"/>
                        do
                        <xsl:variable name="kasati" select="/oba:obavestenje/oba:uvid/oba:kraj_akcije"/>
                        <xsl:variable name="ka" select="substring($kasati,1,5)"/>
                        <xsl:value-of select="$ka"/> časova,
                        u prostorijama organa u <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:mesto"/>
                        ul. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:ulica"/>
                        br. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:adresa/oba:br_ulice"/>,
                        kancelarija br. <xsl:value-of select="/oba:obavestenje/oba:uvid/oba:broj_kancelarije"/> možete izvršiti
                        uvid u dokument/e u kome je sadržana tražena informacija.
                    </p>
                    <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                        Tom prilikom, na vaš zahtev, može vam se izdati i kopija dokumenta sa traženom informacijom.
                    </p>
                    <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                        Troškovi su utvrđeni Uredbom Vlade Republike Srbije („Sl. glasnik RS“, br. 8/06), i to:
                        kopija strane A4 formata iznosi 3 dinara, A3 formata 6 dinara, CD 35 dinara, diskete 20
                        dinara, DVD 40 dinara, audio-kaseta – 150 dinara, video-kaseta 300 dinara, pretvaranje
                        jedne strane dokumenta iz fizičkog u elektronski oblik – 30 dinara.
                    </p>

                    <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                        Iznos ukupnih troškova izrade kopije dokumenta po vašem zahtevu
                        iznosi <xsl:value-of select="/oba:obavestenje/oba:iznos_troskova"/> dinara i uplaćuje se
                        na žiro-račun Budžeta Republike Srbije br. 840-742328-843-30, s pozivom na broj 97 – oznaka
                        šifre opštine/grada gde se nalazi organ vlasti (iz Pravilnika o uslovima i načinu
                        vođenja računa – „Sl. glasnik RS“, 20/07... 40/10).
                    </p>
                    <div style="padding-top:10px">
                        <div style="width:30%;float:left">
                            <p style="font-size:14px; margin-left:40px; text-align:justify;">
                                Dostavljeno
                            </p>
                            <p style="font-size:14px; margin-left:40px; text-align:justify;">
                                <xsl:if test="/oba:obavestenje/oba:dostavljeno='imenovanom'">
                                    <u>1.   Imenovanom</u>  (M.P)
                                </xsl:if>
                                <xsl:if test="not(/oba:obavestenje/oba:dostavljeno='imenovanom')">
                                    1.   Imenovanom      (M.P)
                                </xsl:if>
                            </p>
                            <p style="font-size:14px; margin-left:40px; text-align:justify;">
                                <xsl:if test="/oba:obavestenje/oba:dostavljeno='arhivi'">
                                    <u>2.   Arhivi</u>
                                </xsl:if>
                                <xsl:if test="not(/oba:obavestenje/oba:dostavljeno='arhivi')">
                                    2.   Arhivi
                                </xsl:if>
                            </p>
                        </div>
                        <div style="width:70%;float:right">
                            <p style="font-size:14px; margin-right:40px; text-align:right;">
                                _______________________
                            </p>
                            <p style="font-size:14px; margin-right:40px; text-align:right;">
                                (potpis ovlašćenog lica, odnosno rukovodioca organa)
                            </p>
                        </div>
                    </div>
                    <p style="padding-top:100px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px;"  >
                    </p>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>