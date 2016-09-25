# Domain Driven Design Support Tool

We will develop the Eclipse Plugin to support the development of Domain Driven Design.
Currently, it has published the following Eclipse Plugin.

- Quick class create Plugin
- DDD template create Plugin

## Quick class create Plugin
- Create a java class under package selected in the Package Explorer.

## DDD template create Plugin

- Create Domain Driven Design Template Classes of Selected Domain Class.

 - Identity class
 - Detail class
 - Criteria class
 - FirstClassCollection class
 - Summary class
 - Repository interface
 - Type enumeration

## Requirements

- java6 or later(java8 is recommended)

- eclipse 3.4 or later(4.6 is recommended)

## Binary Download
https://osdn.jp/projects/dddsupport/releases/

## Build

```
1. Get source.
git clone https://github.com/nakag/dddsupport.git

2. execute command below.
cd jp.osdn.dddsupport.releng
mvn celan verify

```

## Installation
1. Unzip jp.osdn.dddsupport.plugin-VERSION.zip into dropins directory.
1. Restart eclipse.

## Usage
### Quick class create Plugin

1. Click on java package with Package explorer.
2. Press alt + shift + F9. And enter a class name in dialog.
3. Click OK button.

### DDD template create Plugin

1. Right click on Java Source(Package explorer or Java Editor).
1. DDD Support->Create DDD Templates(or alt + shift + F8).

## Issues
https://github.com/nakag/dddsupport/issues

## Licence
ASL
