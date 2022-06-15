FILESEXTRAPATHS:prepend := "${THISDIR}/linux-5.15:"

DEPENDS += " ncurses "

SRC_URI:append = " \
    file://cn913x-kmeta;type=kmeta;destsuffix=cn913x-kmeta \
    "

KMACHINE:cn9132-cex7 ?= "cn9132-cex7"
COMPATIBLE_MACHINE:cn9132-cex7 = "cn9132-cex7"

KMACHINE:cn9130-cf-base ?= "cn9130-cf-base"
COMPATIBLE_MACHINE:cn9130-cf-base = "cn9130-cf-base"

