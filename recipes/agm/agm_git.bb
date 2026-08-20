inherit autotools pkgconfig

DESCRIPTION = "agm"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/agm/service"

S = "${WORKDIR}/vendor/qcom/opensource/agm/service"
PR = "r0"

DEPENDS = "glib-2.0 tinyalsa ar-gsl ats acdbdata audio-log-utils"
# This is appended to enable commonlog (CLOG) logging feature
PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'commonlog', 'clog_logging_enabled', '', d)}"

# This is appended to enable dlt-logging feature
PACKAGECONFIG += "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt_logging_enabled', '', d)}"
PACKAGECONFIG[clog_logging_enabled] = "--with-clog, ,commonlog-lib,commonlog-lib"
PACKAGECONFIG[dlt_logging_enabled] = "--with-dltlogging, ,dlt-daemon,dlt-daemon"

EXTRA_OECONF += "--with-glib"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
