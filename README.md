# ti.qrgenerator

<img src="assets/screen.png"/>

Simple QR code geneartor plugin for Titanium SDK - Android. Uses https://github.com/androidmads/QRGenerator with `com.google.zxing:core:3.5.3`

## Example

```js
import QRCode from "ti.qrgenerator";
QRCode.generate({
  text: "Bar",
  margin: 1,
  backgroundColor: "black",
  color: "white",
  dimension: 200,
});
```

full example in the example/ folder.

## Properties:
* text: text that is converted to a qr code (required)
* margin: margin around the code
* backgroundColor: background color behind the code
* color: qr code color
* dimension: size
