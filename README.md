# 16進数配色ドメイン
web上で表現できる16進数ベースの配色ドメインのREST API。
## レイヤリング
ビジネスロジックの表現に注力したドメイン層を中心に複数のレイヤが一方から依存する構造。
ユースケース、ドメインオブジェクトなどドメイン知識の本体は `color-usecase` 配下に配備される。
```
<root>
color-usecase/
└ io.example.color/
 └ domain/ : ドメインオブジェクト、値オブジェクトなど
 └ usecase/ : ユースケースの表現
color-worker/
└ io.example.color.worker/
 └ presentation/ : プレゼンテーション層、タスクレットと設定
build.gradle.kts
settings.gradle.kts
```

各レイヤの依存関係は図の通り

![layring](docs/layering.png)

ドメイン層・プレゼンテーション層はそれぞれ別のGradleプロジェクトであり、マルチプロジェクトとしてビルドされる。

## サンプルユースケース
以下のユースケースを想定している。
1. 2つの色を混ぜる
2. 任意の幅で色を青 | 赤 | 緑にする
3. 過去に生成した色を参照する
4. rgbを指定して色の画像を返す
### このアプリにおけるドメイン知識 vs ユースケース
「2つの色を混ぜる」場合:  
- ドメイン知識
  - 色（ドメイン）そのものが持つ知識・ルール
  - 色の混ぜ方はドメイン知識になる
- ユースケース
  - アプリのクライアントが本アプリに対して行うアクション
  - 「色が混ざるまでの一連の手続きの集合」はユースケースである
参考: [ドメイン知識とユースケースの違いは何か？[ドメイン駆動設計][DDD]](https://little-hands.hatenablog.com/entry/2019/07/26/domain-knowledge)
## アプリケーションインターフェース仕様
16進数の表記にヘッダは不要です

リクエスト仕様
1. 加法混色
2. 減法混色
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