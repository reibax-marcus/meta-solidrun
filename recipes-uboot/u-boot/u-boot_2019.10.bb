require u-boot-common.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

SRC_URI += "\
            file://0001-cmd-add-tlv_eeprom-command.patch \
            file://0002-cmd-tlv_eeprom.patch \
            file://0003-cmd-tlv_eeprom-remove-use-of-global-variable-current.patch \
            file://0004-cmd-tlv_eeprom-remove-use-of-global-variable-has_bee.patch \
            file://0005-cmd-tlv_eeprom-do_tlv_eeprom-stop-using-non-api-read.patch \
            file://0006-cmd-tlv_eeprom-convert-functions-used-by-command-to-.patch \
            file://0007-cmd-tlv_eeprom-remove-empty-function-implementations.patch \
            file://0008-cmd-tlv_eeprom-split-off-tlv-library-from-command.patch \
            file://0009-lib-tlv_eeprom-add-function-for-reading-one-entry-in.patch \
            file://0010-uboot-marvell-patches.patch \
            file://0011-uboot-support-cn913x-solidrun-paltfroms.patch \
            file://0012-add-SoM-and-Carrier-eeproms.patch \
            file://0013-find-fdtfile-from-tlv-eeprom.patch \
            file://0014-octeontx2_cn913x-support-distro-boot.patch \
            file://0015-octeontx2_cn913x-remove-console-variable.patch \
            file://0016-octeontx2_cn913x-enable-mmc-partconf-command.patch \
            file://0001-Add-rbxos-support-environment-variables.patch \
            "

do_compile:prepend() {
    export DEVICE_TREE="${UBOOT_BUILDENV_DEVICE_TREE}"
}

EXTRA_OEMAKE += " EXTRAVERSION=-bsupver[001] "

SYSROOT_DIRS +=  " /boot "
