inherit autotools pkgconfig

DESCRIPTION = "agmtest"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/test"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/test"
PR = "r0"
DEPENDS = "tinyalsa tinycompress sndparser agm glib-2.0 acdbdata"

EXTRA_OECONF += "--with-glib"
EXTRA_OEMAKE += "DEFAULT_INCLUDES=-I${STAGING_INCDIR}/linux-msm/usr/include"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
