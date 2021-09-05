<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:izv="https://github.com/djordjeognjenovic97/XML-projekat/izvestaj"
        version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="izvestaj-page" page-height="29.7cm" page-width="21cm"
                        margin-top="1cm" margin-bottom="2cm" margin-left="2.5cm"
                        margin-right="2.5cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm" />
                    <fo:region-before extent="2cm" />
                    <fo:region-after extent="2cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="izvestaj-page">
                <fo:flow flow-name="xsl-region-body" font-size="12px"
                          text-align="justify">
                    <fo:block text-align="center" font-size="30px" padding="5px">
                        Godišnji izveštaj
                    </fo:block>
                    <fo:block text-align="center" font-size="20px" padding="5px">
                        Zahtevi
                    </fo:block>
                    <fo:block>
                        <fo:table  border="1px solid black">
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-body>
                                <fo:table-row border="1px solid black">
                                    <fo:table-cell>
                                        <fo:block text-align="center">Ukupan broj podnetih</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Usvojeni</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Odbijeni</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Odbačeni</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell text-align="center">
                                        <fo:block>
                                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:ukupanBrPodnetihZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell text-align="center">
                                        <fo:block>
                                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brUsvojenihZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brOdbijenihZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brOdbacenihZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block  text-align="center" font-size="20px" padding="5px">
                        Žalbe
                    </fo:block>
                    <fo:block>
                        <fo:table border="1px solid black">
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-body>
                                <fo:table-row border="1px solid black">
                                    <fo:table-cell>
                                        <fo:block text-align="center">Ukupan broj izjavljenih</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Nije postupio</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Nije postupio u celosti</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Nije postupio u roku</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">Na odluku</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:ukupanBrIzjavljenihZalbi" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupio" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupioUCelosti" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupioURoku" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNaOdluku" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>