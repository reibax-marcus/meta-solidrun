LICENSE = "CLOSED"

SRC_URI = "\
           git://github.com/MarvellEmbeddedProcessors/mv-ddr-marvell.git;nobranch=1;protocol=https \
           file://0001-COMPILE-fix-stack-overflow-warning.patch \
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

FILES:${PN}-dev = "/usr/src/${PN}"
INSANE_SKIP:${PN}-dev += "file-rdeps"
SYSROOT_DIRS +=  " /usr/src/${PN} "

PATCHTOOL = "git"
