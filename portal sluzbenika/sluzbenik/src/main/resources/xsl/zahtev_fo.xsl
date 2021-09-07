<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:ftn="https://github.com/djordjeognjenovic97/XML-projekat/zahtev"
        version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="zahtev-page" page-height="29.7cm" page-width="21cm"
                        margin-top="1cm" margin-bottom="2cm" margin-left="2.5cm"
                        margin-right="2.5cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm" />
                    <fo:region-before extent="2cm" />
                    <fo:region-after extent="2cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="zahtev-page">
                <fo:flow flow-name="xsl-region-body" font-size="12px"
                         text-align="justify">
                        <fo:block text-align="center" font-size="12px">
                            <xsl:value-of select="/ftn:zahtev/ftn:organ/ftn:naziv"/>,
                            <xsl:value-of select="/ftn:zahtev/ftn:organ/ftn:sediste"/>
                        </fo:block>
                        <fo:block text-align="center">
                            ...............................................................................................................
                        </fo:block>
                        <fo:block text-align="center" font-size="12px">
                            naziv i sedište organa kome se zahtev upućuje
                        </fo:block>
                        <fo:block text-align="center" padding-top="40px" font-weight="bold" font-size="20px">
                            Z A H T E V
                        </fo:block>
                        <fo:block text-align="center" font-size="16px">
                                za pristup informaciji od javnog značaja
                        </fo:block>
                        <fo:block font-size="12px" padding-top="15px" text-align="justify">
                            Na osnovu člana 15. st. 1. Zakona o slobodnom pristupu informacijama od javnog značaja
                            („Službeni glasnik RS“, br. 120/04, 54/07, 104/09 i 36/10), od gore navedenog organa zahtevam:*
                        </fo:block>
                        <fo:block-container margin-left="10px" padding-top="5px">
                                <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:obavestenje_posedovanje">
                                    <fo:block font-size="12px" text-decoration="underline">
                                        obaveštenje da li poseduje traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:obavestenje_posedovanje)">
                                    <fo:block font-size="12px">
                                        obaveštenje da li poseduje traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:uvid_dokument">
                                    <fo:block font-size="12px" text-decoration="underline">
                                        uvid u dokument koji sadrži traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:uvid_dokument)">
                                    <fo:block font-size="12px">
                                        uvid u dokument koji sadrži traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:kopija_dokument">
                                    <fo:block font-size="12px" text-decoration="underline">
                                        kopiju dokumenta koji sadrži traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:kopija_dokument)">
                                    <fo:block font-size="12px">
                                        kopiju dokumenta koji sadrži traženu informaciju;
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije">
                                    <fo:block font-size="12px" text-decoration="underline">
                                        dostavljanje kopije dokumenta koji sadrži traženu informaciju:**
                                    </fo:block>
                                </xsl:if>
                                <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije)">
                                    <fo:block font-size="12px" >
                                        dostavljanje kopije dokumenta koji sadrži traženu informaciju:**
                                    </fo:block>
                                </xsl:if>
                                <fo:block margin-left="20px">
                                    <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:posta">
                                        <fo:block font-size="12px" text-decoration="underline">
                                            poštom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:posta)">
                                        <fo:block font-size="12px">
                                            poštom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:elektronska_posta">
                                        <fo:block font-size="12px" text-decoration="underline">
                                            elektronskom poštom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:elektronska_posta)">
                                        <fo:block font-size="12px">
                                            elektronskom poštom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:faks">
                                        <fo:block font-size="12px" text-decoration="underline">
                                            faksom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:faks)">
                                        <fo:block font-size="12px">
                                            faksom
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin">
                                        <fo:block font-size="12px" text-decoration="underline">
                                            na drugi način:***  <xsl:value-of select="/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin"/>
                                        </fo:block>
                                    </xsl:if>
                                    <xsl:if test="not(/ftn:zahtev/ftn:sadrzaj/ftn:tipovi_zahteva/ftn:dostavljanje_kopije/ftn:drugi_nacin)">
                                        <fo:block font-size="12px">
                                            na drugi način:***
                                        </fo:block>
                                    </xsl:if>
                                </fo:block>
                        </fo:block-container>
                        <fo:block font-size="12px" padding-top="10px" margin-left="20px">
                            Ovaj zahtev se odnosi na sledeće informacije:
                        </fo:block>
                        <fo:block font-size="12px" padding-top="5px" >
                            <xsl:value-of select="/ftn:zahtev/ftn:sadrzaj/ftn:opis_informacije"/>
                        </fo:block>
                        <fo:block font-size="9px" padding-top="5px">
                            (navesti što precizniji opis informacije koja se traži kao i druge podatke koji olakšavaju pronalaženje tražene informacije)
                        </fo:block>
                        <fo:block padding-top="30px">
                            <fo:inline-container inline-progression-dimension="50%">
                                <fo:block font-size="12px">
                                    U <xsl:value-of select="/ftn:zahtev/ftn:mesto_podnosenja_zahteva"/>,
                                </fo:block>
                                <fo:block font-size="12px" padding-top="15px">
                                    <xsl:variable name="datum" select="/ftn:zahtev/ftn:datum_podnosenja_zahteva"/>
                                    <xsl:variable name="dan" select="substring($datum,9,2)"/>
                                    <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                                    <xsl:variable name="godina" select="substring($datum,1,4)"/>
                                    Dana <xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>.
                                </fo:block>
                            </fo:inline-container>
                            <fo:inline-container inline-progression-dimension="50%" text-align="center">
                                <fo:block font-size="12px">
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:ime"/>&#160;
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:prezime"/>
                                </fo:block>
                                <fo:block font-size="12px" padding-top="15px">
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:mesto"/>,
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:ulica"/>&#160;
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:adresa/ftn:br_ulice"/>
                                </fo:block>
                                <fo:block font-size="12px" padding-top="15px">
                                    <xsl:value-of select="/ftn:zahtev/ftn:trazilac_informacije/ftn:drugi_kontakt_podaci"/>
                                </fo:block>
                                <fo:block font-size="12px" padding-top="15px">
                                    _______________________
                                </fo:block>
                                <fo:block text-align="center" font-size="12px">
                                    Potpis
                                </fo:block>
                            </fo:inline-container>
                        </fo:block>
                            <fo:block font-size="10px" padding-top="50px">
                                __________________________________________
                            </fo:block>
                            <fo:block font-size="9px" >
                                * U kućici označiti koja zakonska prava na pristup informacijama želite da ostvarite.
                            </fo:block>
                            <fo:block font-size="9px" >
                                ** U kućici označiti način dostavljanja kopije dokumenta.
                            </fo:block>
                            <fo:block font-size="9px" >
                                *** Kada zahtevate drugi način dostavljanja obavezno upisati koji način dostavljanja zahtevate.
                            </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>