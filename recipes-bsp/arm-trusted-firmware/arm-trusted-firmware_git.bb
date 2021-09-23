# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   license.rst
#   lib/compiler-rt/LICENSE.TXT
#   docs/license.rst
DESCRIPTION = "ARM Trusted Firmware"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://license.rst;md5=1dd070c98a281d18d9eefd938729b031 \
                    file://lib/compiler-rt/LICENSE.TXT;md5=bf24bca27049b52e9738451aa55771d4 \
                    file://docs/license.rst;md5=189505435dbcdcc8caa63c46fe93fa89"

inherit deploy kernel-arch

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "mv-ddr-marvell virtual/bootloader openssl openssl-native coreutils-native"
SRC_URI = "\
           git://github.com/ARM-software/arm-trusted-firmware.git;protocol=https \
           file://mrvl_scp_bl2.img \
           file://0001-Fix-fiptool-native-compilation.patch \
           "

SRC_URI_append_cn9130-cf-base = " file://arm-trusted-firmware-temp-fix-cn9130-som-rev-1.0.patch "

# Modify these as desired
PV = "2.3+git${SRCPV}"
SRCREV = "00ad74c7afe67b2ffaf08300710f18d3dafebb45"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

HOST_CC_ARCH += " -Wno-error=sizeof-pointer-div "

# requires CROSS_COMPILE set by hand as there is no configure script
export CROSS_COMPILE="${TARGET_PREFIX}"

# Let the Makefile handle the LDFLAGS
LDFLAGS[unexport] = "1"
CFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

CP_NUM_cn9132-cex7 = "3"
CP_NUM_cn9130-cf-base = "1"

do_compile () {
    export SCP_BL2="${WORKDIR}/mrvl_scp_bl2.img"
    export BL33="${RECIPE_SYSROOT}/boot/u-boot.bin"

    # You will almost certainly need to add additional arguments here
    oe_runmake USE_COHERENT_MEM=0 LOG_LEVEL=20 PLAT=t9130 MV_DDR_PATH=${PKG_CONFIG_SYSROOT_DIR}/usr/src/mv-ddr-marvell CP_NUM=${CP_NUM} all fip
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
    install -d ${D}/lib/firmware
    install -m 0644 ${B}/build/t9130/release/flash-image.bin ${D}/lib/firmware
}

do_deploy () {
    install -d ${DEPLOYDIR}/fsbl
    install -m 0644 ${D}/lib/firmware/flash-image.bin ${DEPLOYDIR}/fsbl/
}
addtask deploy after do_install before do_package

FILES_${PN} = "/lib/firmware"
