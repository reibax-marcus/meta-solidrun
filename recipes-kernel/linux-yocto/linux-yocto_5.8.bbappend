FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += " ncurses "

KBRANCH_cn9132-cex7 = "v5.8/standard/base"
KMACHINE_cn9132-cex7 ?= "cn9132-cex7"
SRCREV_machine_cn9132-cex7 ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE_cn9132-cex7 = "cn9132-cex7"
LINUX_VERSION_cn9132-cex7 = "5.8.18"

SRC_URI_append_cn9132-cex7 = " \
    file://cn9132-cex7;type=kmeta;destsuffix=cn9132-cex7 \
    "
