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
                <h1 style="text-align:center">Godišnji izveštaj</h1>
                <h2 style="text-align:center">Zahtevi</h2>
                <table style="text-align:center; border: 1px solid black;">
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
                <table style="text-align:center">
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
<!--                <p>Датум подношења извештаја:-->
<!--                    <xsl:value-of select="/izv:izvestaj/izv:datum" />-->
<!--                </p>-->
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>