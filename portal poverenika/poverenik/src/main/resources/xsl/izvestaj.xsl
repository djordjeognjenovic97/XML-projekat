<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:izv="https://github.com/djordjeognjenovic97/XML-projekat/izvestaj"
        version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    table, td, th {
                    border: 1px solid black;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    }
                </style>
            </head>

            <body>
                <xsl:variable name="datum" select="/izv:izvestaj/izv:datum"/>
                <xsl:variable name="dan" select="substring($datum,9,2)"/>
                <xsl:variable name="mesec" select="substring($datum,6,2)"/>
                <xsl:variable name="godina" select="substring($datum,1,4)"/>
                <h1 style="text-align:center">Godišnji izveštaj za godinu <xsl:value-of select="$godina"/>.</h1>
                <h2 style="text-align:center">Zahtevi</h2>
                <table style="text-align:center; border: 1px solid black; width:60%;margin-left: auto;margin-right: auto;">
                    <tr>
                        <th>Ukupan broj podnetih</th>
                        <th>Usvojeni</th>
                        <th>Odbijeni</th>
                        <th>Odbačeni</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:ukupanBrPodnetihZahteva" />
                        </td>

                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brUsvojenihZahteva" />
                        </td>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brOdbijenihZahteva" />
                        </td>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zahtevi/izv:brOdbacenihZahteva" />
                        </td>
                    </tr>
                </table>
                <h2 style="text-align:center">Žalbe</h2>
                <table style="text-align:center; width:60%;margin-left: auto;margin-right: auto;" >
                    <tr>
                        <th>Ukupan broj izjavljenih</th>
                        <th>Nije postupio</th>
                        <th>Nije postupio u celosti</th>
                        <th>Nije postupio u roku</th>
                        <th>Na odluku</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:ukupanBrIzjavljenihZalbi" />
                        </td>

                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupio" />
                        </td>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupioUCelosti" />
                        </td>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNijePostupioURoku" />
                        </td>
                        <td>
                            <xsl:value-of select="/izv:izvestaj/izv:zalbe/izv:brZalbiNaOdluku" />
                        </td>
                    </tr>
                </table>
                <p style="padding-top:15px; margin-left:20%;">Datum podnošenja izveštaja:
                    <xsl:value-of select="$dan"/>.<xsl:value-of select="$mesec"/>.<xsl:value-of select="$godina"/>.
                </p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>