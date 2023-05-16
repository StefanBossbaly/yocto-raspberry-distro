inherit cargo

SUMMARY = "SEPTA Async Rust API Client"
HOMEPAGE = "https://github.com/StefanBossbaly/septa-api/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=271ce9b1608fe88327caafa1d0e38835 \
"

# If this is git based prefer versioned ones if they exist
DEFAULT_PREFERENCE = "-1"

# how to get septa-api could be as easy as but default to a git checkout:
SRC_URI += "git://git@github.com/StefanBossbaly/septa-api.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include septa-api-${PV}.inc
include septa-api.inc
