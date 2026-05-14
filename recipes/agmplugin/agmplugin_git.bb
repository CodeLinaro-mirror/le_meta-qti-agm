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
DEPENDS = "tinyalsa tinycompress agm-sw-binder-client sndparser acdbdata glib-2.0 audio-log-utils"

#eXTRA_OEMAKE = "DEFAULT_INCLUDES= CPPFLAGS="-I. -I${STAGING_KERNEL_DIR}/include/uapi""

EXTRA_OECONF += "--with-glib"
#EXTRA_OECONF += "--with-sanitized-headers=${STAGING_KERNEL_BUILDDIR}/usr/include"
#EXTRA_OECONF += "--with-sanitized-headers=${STAGING_KERNEL_DIR}/include/uapi"
#EXTRA_OECONF += "--with-audio-headers=${STAGING_KERNEL_BUILDDIR}/source/techpack/audio/include/uapi/audio/"
#DEPENDS = "libcutils libion virtual/kernel system-prop glib-2.0"
FILES:${PN}-dbg  = "${libdir}/.debug/*"
FILES:${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"

PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt_logging_enabled', '', d)}"
PACKAGECONFIG[dlt_logging_enabled] = "--with-dltlogging,--without-dltlogging,dlt-daemon"
