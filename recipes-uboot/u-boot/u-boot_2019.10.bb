require u-boot-common.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

SRC_URI += "\
            file://0001-u-boot-dts-cn913x-com-express-type-7.patch \
            file://0002-u-boot-makefile-add-cn913x-com-express-type7-dts.patch \
            file://0003-config-cn913x-com-express-type-7-defonfig.patch \
            file://0004-u-boot-disable-board_fix_fdt-on-cn913x-com-epress-ty.patch \
            file://0005-u-boot-fix-i2c1-setting.patch \
            file://0006-build-dts-for-CN913x-CEx7-by-SolidRun.patch \
            file://0007-u-boot-config-Makefile-and-defconfig-cex7-cn913x.patch \
            file://0008-u-boot-update-device-tree-of-cn9130-cex7.patch \
            "
