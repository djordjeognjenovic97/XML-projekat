<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns="https://github.com/djordjeognjenovic97/XML-projekat/zalbanaodlukucir"
        version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="zalbanaodlukuStranica" page-height="29.7cm" page-width="21cm"
                        margin-top="1cm" margin-bottom="2cm" margin-left="2.5cm"
                        margin-right="2.5cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm" />
                    <fo:region-before extent="2cm" />
                    <fo:region-after extent="2cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="zalbanaodlukuStranica">
                <fo:flow flow-name="xsl-region-body" font-size="12px"
                         font-family="Times" text-align="justify">
                    <fo:block text-align="center" font-size="22px"
                              space-after="16px">
                        Radi
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>