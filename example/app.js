const win = Ti.UI.createWindow();
const img = Ti.UI.createImageView({ width: 200, height: 200, top: 0 });
const img2 = Ti.UI.createImageView({ width: 200, height: 200 });
const img3 = Ti.UI.createImageView({ width: 200, height: 200, bottom: 0 });
win.add([img, img2, img3]);
win.open();

import QRCode from "ti.qrgenerator";

img3.image = QRCode.generate({
  text: "FooBar",
});

img.image = QRCode.generate({
  text: "Foo",
  backgroundColor: "red",
  color: "blue",
  dimension: 200,
});

img2.image = QRCode.generate({
  text: "Bar",
  margin: 1,
  backgroundColor: "black",
  color: "white",
});
