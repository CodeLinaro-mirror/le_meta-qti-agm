inherit autotools pkgconfig

DESCRIPTION = "agmplugin"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/plugins/tinyalsa/"

S = "${WORKDIR}/vendor/qcom/opensource/agm/plugins/tinyalsa/"
PR = "r0"
DEPENDS = "tinyalsa tinycompress sndparser acdbdata glib-2.0 audio-log-utils"
DEPENDS += "${@bb.utils.contains('BASEMACHINE', 'sdxlemur', 'agm-sw-binder-client', 'agm-client', d)}"

#eXTRA_OEMAKE = "DEFAULT_INCLUDES= CPPFLAGS="-I. -I${STAGING_KERNEL_DIR}/include/uapi""

EXTRA_OECONF += "--with-glib"
#EXTRA_OECONF += "--with-sanitized-headers=${STAGING_KERNEL_BUILDDIR}/usr/include"
#EXTRA_OECONF += "--with-sanitized-headers=${STAGING_KERNEL_DIR}/include/uapi"
#EXTRA_OECONF += "--with-audio-headers=${STAGING_KERNEL_BUILDDIR}/source/techpack/audio/include/uapi/audio/"
#DEPENDS = "libcutils libion virtual/kernel system-prop glib-2.0"
FILES_${PN}-dbg  = "${libdir}/.debug/*"
FILES_${PN}      = "${libdir}/*.so ${libdir}/*.so.* ${sysconfdir}/* ${libdir}/pkgconfig/* ${bindir}/* ${sbindir}/*"
FILES_${PN}-dev  = "${libdir}/*.la ${includedir}"
