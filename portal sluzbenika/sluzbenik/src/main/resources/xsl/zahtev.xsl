<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:xs="http://www.w3.org/2001/XMLSchema"
        xmlns:ftn="https://github.com/djordjeognjenovic97/XML-projekat/zahtev"
        version="3.0">

    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">

                </style>
            </head>
            <body>
                <div style="width:40%; margin:0 auto; border: 2px solid black;">
                <p style="font-size:14px; text-align:center;margin: 0%; padding-top:5px;">
                    <xsl:value-of select="/ftn:zahtev/ftn:organ/ftn:naziv"/>,
                    <xsl:value-of select="/ftn:zahtev/ftn:organ/ftn:sediste"/>
                </p>
                <p style="text-align:center;margin: 0%;">
                    ...............................................................................................................
                </p>
                <p style="font-size:14px; text-align:center;margin: 0%; ">
                    naziv i sedište organa kome se zahtev upućuje
                </p>
                <h1 style="text-align:center;padding-top:30px;font-weight: bold">
                    Z A H T E V
                </h1>
                <h2 style="font-size:16px; text-align:center">
                    za pristup informaciji od javnog značaja
                </h2>
                <p style="padding-top:20px;font-size:14px; text-align:justify; padding-left:15px; padding-right:15px; padding-bottom:5px;"  >
                    Na osnovu člana 15. st. 1. Zakona o slobodnom pristupu informacijama od javnog značaja
                    („Službeni glasnik RS“, br. 120/04, 54/07, 104/09 i 36/10), od gore navedenog organa zahtevam:*
                </p>
                <p style="font-size:14px;margin:0%; margin-left:40px; text-align:justify;" >
                    <p style="font-size:14px;margin:0%; margin-left:40px; text-align:justify;" >
                        <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:obavestenje_posedovanje">
                            obaveštenje da li poseduje traženu informaciju;
                            <input type="checkbox" checked="true" disabled="true">
                            </input>
                        </xsl:if>
                        <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:obavestenje_posedovanje)">
                            obaveštenje da li poseduje traženu informaciju;
                            <input type="checkbox" disabled="true">
                            </input>
                        </xsl:if>
                    </p>
                    <p style="font-size:14px;margin:0%; margin-left:40px; text-align:justify;" >
                        <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:uvid_dokument">
                            uvid u dokument koji sadrži traženu informaciju;
                            <input type="checkbox" checked="true" disabled="true">
                            </input>
                        </xsl:if>
                        <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:uvid_dokument)">
                            uvid u dokument koji sadrži traženu informaciju;
                            <input type="checkbox" disabled="true">
                            </input>
                        </xsl:if>
                    </p>
                    <p style="font-size:14px;margin:0%; margin-left:40px; text-align:justify;" >
                        <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:kopija_dokument">
                            kopiju dokumenta koji sadrži traženu informaciju;
                            <input type="checkbox" checked="true" disabled="true">
                            </input>
                        </xsl:if>
                        <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:kopija_dokument)">
                            kopiju dokumenta koji sadrži traženu informaciju;
                            <input type="checkbox" disabled="true">
                            </input>
                        </xsl:if>
                    </p>
                    <p style="font-size:14px;margin:0%; margin-left:40px; text-align:justify;" >
                        <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije">
                            dostavljanje kopije dokumenta koji sadrži traženu informaciju:**
                            <input type="checkbox" checked="true" disabled="true">
                            </input>
                        </xsl:if>
                        <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije)">
                            dostavljanje kopije dokumenta koji sadrži traženu informaciju:**
                            <input type="checkbox" disabled="true">
                            </input>
                        </xsl:if>
                    </p>
                    <p style="font-size:14px; margin:0%;margin-left:80px; text-align:justify;" >
                        <p style="font-size:14px; margin:0%;margin-left:80px; text-align:justify;" >
                            <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:posta">
                                poštom
                                <input type="checkbox" checked="true" disabled="true">
                                </input>
                            </xsl:if>
                            <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:posta)">
                                poštom
                                <input type="checkbox" disabled="true">
                                </input>
                            </xsl:if>
                        </p>
                        <p style="font-size:14px; margin:0%;margin-left:80px; text-align:justify;" >
                            <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:elektronska_posta">
                                elektronskom poštom
                                <input type="checkbox" checked="true" disabled="true">
                                </input>
                            </xsl:if>
                            <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:elektronska_posta)">
                                elektronskom poštom
                                <input type="checkbox"  disabled="true">
                                </input>
                            </xsl:if>
                        </p>
                        <p style="font-size:14px; margin:0%;margin-left:80px; text-align:justify;" >
                            <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:faks">
                                faksom
                                <input type="checkbox" checked="true" disabled="true">
                                </input>
                            </xsl:if>
                            <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:faks)">
                                faksom
                                <input type="checkbox" disabled="true">
                                </input>
                            </xsl:if>
                        </p>
                        <p style="font-size:14px; margin:0%;margin-left:80px; text-align:justify;" >
                            <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin">
                                na drugi način:***
                                <input type="checkbox" checked="true" disabled="true">
                                </input>
                                <xsl:value-of select="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin"/>
                            </xsl:if>
                            <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin)">
                                na drugi način:***
                                <input type="checkbox"  disabled="true">
                                </input>
                            </xsl:if>
                        </p>
                    </p>
                </p>
                <p style="font-size:14px; margin-left:40px; text-align:justify;" >
                    Ovaj zahtev se odnosi na sledeće informacije:
                </p>
                <p style="font-size:14px; margin-left:40px; text-align:justify;" >
                    <xsl:value-of select="/ftn:zahtev/ftn:sadrzaj/ftn:opis_informacije"/>
                </p>
                <p style="font-size:10px;text-align:justify; padding-left:15px; padding-right:15px; margin:0%;" >
                    (navesti što precizniji opis informacije koja se traži kao i druge podatke koji olakšavaju pronalaženje tražene informacije)
                </p>
                <div style="padding-top:10px">
                <div style="width:40%;float:left">
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        U <xsl:value-of select="/ftn:zahtev/ftn:mesto_podnosenja_zahteva"/>,
                    </p>
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        <xsl:variable name="datum" select="/ftn:zahtev/ftn:datum_podnosenja_zahteva"/>
                        <xsl:variable name="dan" select="substring($datum,9,2)"/>
                        <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                        <xsl:variable name="godina" select="substring($datum,1,4)"/>
                        Dana <xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>.
                    </p>
                </div>
                <div style="width:50%;float:right">
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:ime"/>&#160;
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:prezime"/>
                    </p>
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:mesto"/>,
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:ulica"/>&#160;
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:br_ulice"/>
                    </p>
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:drugi_kontakt_podaci"/>
                    </p>
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        _______________________
                    </p>
                    <p style="font-size:14px; margin-left:40px; text-align:justify;">
                        Potpis
                    </p>
                </div>
                </div>
                <div style="padding-top:50px">
                <p style="font-size:10px; padding-top:100px; padding-left:15px; margin:0%;" >
                    __________________________________________
                </p>
                <p style="font-size:10px; padding-left:15px;margin:0%;" >
                    * U kućici označiti koja zakonska prava na pristup informacijama želite da ostvarite.
                </p>
                <p style="font-size:10px; padding-left:15px; margin:0%;" >
                    ** U kućici označiti način dostavljanja kopije dokumenta.
                </p>
                <p style="font-size:10px; padding-left:15px; margin:0%;" >
                    *** Kada zahtevate drugi način dostavljanja obavezno upisati koji način dostavljanja zahtevate.
                </p>
                </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>