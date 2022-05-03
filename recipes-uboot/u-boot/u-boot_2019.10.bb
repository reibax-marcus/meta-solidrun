require u-boot-common.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

SRC_URI += "\
            file://0001-uboot-marvell-patches.patch \
            file://0002-uboot-support-cn913x-solidrun-paltfroms.patch \
            file://0001-Add-rbxos-support-environment-variables.patch \
            "

do_compile:prepend() {
    export DEVICE_TREE="${UBOOT_BUILDENV_DEVICE_TREE}"
}

EXTRA_OEMAKE += " EXTRAVERSION=-bsupver[001] "

SYSROOT_DIRS +=  " /boot "
