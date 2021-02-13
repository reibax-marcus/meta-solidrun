FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += " ncurses "

KBRANCH_cn9132 = "v5.8/standard/base"
KMACHINE_cn9132 ?= "cn9132"
SRCREV_machine_cn9132 ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE_cn9132 = "cn9132"
LINUX_VERSION_cn9132 = "5.8.18"

SRC_URI_append_cn9132 = " \
    file://cn9132;type=kmeta;destsuffix=cn9132 \
    "
