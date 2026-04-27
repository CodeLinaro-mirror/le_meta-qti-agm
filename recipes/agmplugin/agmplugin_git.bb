inherit autotools pkgconfig

DESCRIPTION = "agmplugin"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/"
PR = "r0"
DEPENDS = "tinyalsa tinycompress agm sndparser"

EXTRA_OEMAKE = "DEFAULT_INCLUDES=-I${STAGING_KERNEL_BUILDDIR}/usr/include"
EXTRA_OECONF += "--with-agm-no-ipc"

FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
