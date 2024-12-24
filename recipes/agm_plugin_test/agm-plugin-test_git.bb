inherit autotools pkgconfig

DESCRIPTION = "agmtest"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/test"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/test"

do_install:append() {
       install -d ${D}${sysconfdir}
       install -m 0755 ${S}/*.xml ${D}${sysconfdir}/
}

PR = "r0"
DEPENDS = "tinycompress sndparser"

EXTRA_OECONF += "--with-glib"
EXTRA_OEMAKE += "DEFAULT_INCLUDES=-I${STAGING_KERNEL_BUILDDIR}/usr/include"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
