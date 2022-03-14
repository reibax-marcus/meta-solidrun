require u-boot-common.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

SRC_URI += "\
            file://0001-uboot-marvell-patches.patch \
            file://0002-uboot-support-cn913x-solidrun-paltfroms.patch \
            "

do_compile:prepend() {
    export DEVICE_TREE="${UBOOT_BUILDENV_DEVICE_TREE}"
}

SYSROOT_DIRS +=  " /boot "
