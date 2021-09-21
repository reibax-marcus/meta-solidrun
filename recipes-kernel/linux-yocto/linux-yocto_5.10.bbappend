FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += " ncurses "

SRC_URI_append = " \
    file://cn913x-kmeta;type=kmeta;destsuffix=cn913x-kmeta \
    "

#KBRANCH_cn9132-cex7 = "v5.8/standard/base"
KMACHINE_cn9132-cex7 ?= "cn9132-cex7"
#SRCREV_machine_cn9132-cex7 ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE_cn9132-cex7 = "cn9132-cex7"
#LINUX_VERSION_cn9132-cex7 = "5.8.18"

#KBRANCH_cn9130-cf-base = "v5.8/standard/base"
KMACHINE_cn9130-cf-base ?= "cn9130-cf-base"
#SRCREV_machine_cn9130-cf-base ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE_cn9130-cf-base = "cn9130-cf-base"
#LINUX_VERSION_cn9130-cf-base = "5.8.18"

