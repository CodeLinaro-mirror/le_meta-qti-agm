#SUMMARY = "QTI Audio Package Group"

LICENSE = "BSD-3-Clause"

RDEPENDS:packagegroup-qti-audio += ' \
    agmplugin \
    agm-plugin-test \
    agm \
    ${@bb.utils.contains_any('BASEMACHINE', "sdxlemur sa525m sa510m" , 'agm-sw-binder-client', '', d)} \
    ${@bb.utils.contains_any('BASEMACHINE', "sdxlemur sa52m sa510m", 'agm-sw-binder-server', '', d)} \
'
