# Yocto Raspberry Distro

The goal of this project to to house the various repositories layers needed to build a Yocto image for Raspberry Pi.
The repository will use git submodules to reference the `meta-*` layers and include Bitbake configuration files to ensure
that all layers are added correctly to the project. In the future I hope to add some convince scripts that will be able
to configure the build area bases on user select criteria.

## Why Yocto?

Yocto allows the building of an embedded Linux distro that is tailor made for a specific needs and platform while also being versatile
to support other SoC/architectures if needed in the future (and given the prices and availability of pis, it is a very real possibility).
While it is certainly possible to use a stripped down distro like Raspberry Pi OS Lite, the image is still 300MB+ and still has to be
configured inorder to run you application software. With Yotco all the configuration is handled during the Bitbake process and the
output is a configured and ready to deploy image with all the software you need and nothing more.

## Docker

Currently I use Fedora for my personal laptop (which is not a supported build environment). Regardless if you use a supported
build environment natively, it is generally a good idea to use a container to ensure that all dependencies are meet. I use
the [crops/poky](https://github.com/crops/poky-container) container for my builds. Below is the command to launch a container
with work area mounted, just replace `$REPO_ROOT` with location of this cloned repository.

```
docker run --rm -it --net=host -v $REPO_ROOT:/workdir crops/poky --workdir=/workdir
```

## Setup

To get started, simply `source` the `poky/oe-init-build-env` script in the Docker container with the desired build directory, like so:

```
source ./poky/oe-init-build-env build-pi4-64
```

Once that script is run, you bash shell should now have everything it needs to start Bitbaking.

## Building

To build an image simply run the `bitbake` command. Currently there are two images in the `meta-application` layer:
* `transit-board-dev-image`: Image that contains application and debug tools like gdb, objdump, and allows paswordless ssh
root access to the device.
* `transit-board-prod-image`: Image that contains application and necessary dependencies.

## Emulator

Openembedded provides support for the qemu emulator. It can be quite helpful when debugging build issues quickly without having
the need to deploy to an actual target device. Since I do my builds in a Docker container, I also have to run the emulator in the
container as well. To build for qemu, change the `MACHINE` variable to `qemuarm64` in the local.conf file. Then Bitbake the desired
image. Once complete you can run emulator using the command below:

```
runqemu nographic slirp
```

We use `nographic` since we want a headless instance and `slirp` since we are running in a container and tun/tap interface is not needed
for networking.

## Authors

Stefan Bossbaly

## Acknowledgments

- [poky](https://git.yoctoproject.org/poky) 
- [meta-openembedded](https://git.openembedded.org/meta-openembedded) 
- [meta-raspberrypi](https://git.yoctoproject.org/meta-raspberrypi)
- [meta-rust](https://github.com/meta-rust/meta-rust)
- [meta-clang](https://github.com/kraj/meta-clang)

