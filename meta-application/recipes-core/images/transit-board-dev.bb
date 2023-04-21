SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES:append = " allow-empty-password allow-root-login debug-tweaks empty-root-password ssh-server-dropbear"

IMAGE_INSTALL:append = " rust-hello-world"

LICENSE = "MIT"

inherit core-image