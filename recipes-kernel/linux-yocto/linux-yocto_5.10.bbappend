FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += " ncurses "

SRC_URI:append = " \
    file://cn913x-kmeta;type=kmeta;destsuffix=cn913x-kmeta \
    "

#KBRANCH:cn9132-cex7 = "v5.8/standard/base"
KMACHINE:cn9132-cex7 ?= "cn9132-cex7"
#SRCREV:machine_cn9132-cex7 ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE:cn9132-cex7 = "cn9132-cex7"
#LINUX_VERSION:cn9132-cex7 = "5.8.18"

#KBRANCH:cn9130-cf-base = "v5.8/standard/base"
KMACHINE:cn9130-cf-base ?= "cn9130-cf-base"
#SRCREV:machine_cn9130-cf-base ?= "ab435ce49bd1d02e33dfec24f76955dc1196970b"
COMPATIBLE_MACHINE:cn9130-cf-base = "cn9130-cf-base"
#LINUX_VERSION:cn9130-cf-base = "5.8.18"

