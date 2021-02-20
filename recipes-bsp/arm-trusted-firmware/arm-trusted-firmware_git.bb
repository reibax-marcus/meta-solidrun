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
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://license.rst;md5=1dd070c98a281d18d9eefd938729b031 \
                    file://lib/compiler-rt/LICENSE.TXT;md5=bf24bca27049b52e9738451aa55771d4 \
                    file://docs/license.rst;md5=189505435dbcdcc8caa63c46fe93fa89"

DEPENDS = "mv-ddr-marvell"
SRC_URI = "\
           git://github.com/ARM-software/arm-trusted-firmware.git;protocol=https \
           file://mrvl_scp_bl2.img \
           "

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

do_compile () {
    export SCP_BL2="${WORKDIR}/mrvl_scp_bl2.img"
    export CROSS_COMPILE=${HOST_PREFIX}
#    export ARCH=arm64
    export ARCH=aarch64
#    alias gcc=aarch64-poky-linux-gcc
	# You will almost certainly need to add additional arguments here
	oe_runmake USE_COHERENT_MEM=0 LOG_LEVEL=20 PLAT=t9130 MV_DDR_PATH=${PKG_CONFIG_SYSROOT_DIR}/usr/src/mv-ddr-marvell CP_NUM=3 all fip
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
	:
}

