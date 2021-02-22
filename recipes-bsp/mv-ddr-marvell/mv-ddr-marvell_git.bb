# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   drivers/snps/fw/snps_license.txt
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://drivers/snps/fw/snps_license.txt;md5=eec6820d302b600f6c1dc29d86f75ccb"

SRC_URI = "\
           git://github.com/MarvellEmbeddedProcessors/mv-ddr-marvell.git;nobranch=1;protocol=https \
           file://0001-Hide-snps_fw.c-compilation-error.patch \
           file://0002-Avoid-multiple-definition-of-gd-error.patch \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "305d923e6bc4236cd3b902f6679b0aef9e5fa52d"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
   # This is a special package. It will be built by arm-trusted-firmware
   :
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
    install -d "${D}/usr/src/${PN}"
    cp -r "${S}/." "${D}/usr/src/${PN}/"
    cd "${D}/usr/src/${PN}" && rm -fr .git
}

FILES_${PN}-dev = "/usr/src/${PN}"
INSANE_SKIP_${PN}-dev += "file-rdeps"
SYSROOT_DIRS +=  " /usr/src/${PN} "
