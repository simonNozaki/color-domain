# 16進数配色ドメイン
web上で表現できる16進数ベースの配色ドメインのREST API。
## レイヤリング
のちほど更新。
## サンプルユースケース
以下のユースケースを想定している。
1. 2つの色を混ぜる
2. 任意の幅で色を青 | 赤 | 緑にする
3. 過去に生成した色を参照する
4. rgbを指定して色の画像を返す
## API IF
16進数の表記にヘッダは不要です
1. 2つの色を混ぜる
```json
{
    "mixedIn": "FF0000",
    "mixingIn": "00FF00"
}
```
## web上での色の混ぜ方、基礎知識
こちらのページを参考にしました。

- [色とRGB値と16進数について｜フルカラーの取り扱い：IT基礎](http://www.howisit.jp/2017/01/24/control-color/#section220)

色の演算ルールは以下のとおり
- R, G, Bすべて1バイト以下に収まる。各領域とも最大が00、最大がFFである。
- R, G, Bの各領域の加法が他の領域に繰り上げ・繰り下げとなることはない。