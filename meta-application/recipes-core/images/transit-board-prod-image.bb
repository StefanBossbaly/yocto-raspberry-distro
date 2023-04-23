SUMMARY = "Transit board production image"

IMAGE_FEATURES:append = " allow-empty-password allow-root-login debug-tweaks empty-root-password ssh-server-dropbear"

IMAGE_INSTALL:append = " rpi-rgb-led-matrix"

LICENSE = "MIT"

inherit core-image