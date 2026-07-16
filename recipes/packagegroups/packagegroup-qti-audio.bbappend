#SUMMARY = "QTI Audio Package Group"

LICENSE = "BSD-3-Clause"

RDEPENDS:packagegroup-qti-audio += ' \
    agm \
    agmplugin \
    agm-plugin-test \
    ${@bb.utils.contains_any('BASEMACHINE', "sdxlemur sa525m sa510m sdxpinn" , 'agm-sw-binder-client', '', d)} \
    ${@bb.utils.contains_any('BASEMACHINE', "sdxlemur sa525m sa510m sdxpinn" , 'agm-sw-binder-client', '', d)} \
'
