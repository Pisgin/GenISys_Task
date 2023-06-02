
@wip
Feature: kullanıcı sisteme register olabilmeli


  Scenario: kullanici sisteme register olabilmelidir

    Given kullanici tour sayfasına gelebilmeli
    When kullanici yeni kullanici girisi yapabilmeli
    And kullanici email adresini girebilmeli
    And kullanici telefon numarasi girebilmeli
    And kullanici ad soyad girisi yapabilmeli
    And kullanici sifre belirleyebilmeli
    Then kullanicinin kayit islemi tamamlanmalidir..


  Scenario: register olan kullanici bilgisi ile login olabilmelidir

    Given kullanici tour sayfasına gelebilmeli
    When kullanici login olabilmeli
    Then kullanici login oldugunu check edebilmelidir



  Scenario: kullanici Casino oyununu bakiyesi olmadan oynayamadigini gorebilmelidir

    Given kullanici tour sayfasindan login olabilmeli
    When kullanici Casino sayfasina girdebilmeli
    Then kullanici bakiyesi olmadan oyun oynayamadigini gorebilmelidir


  Scenario: kullanici Casino oyununda kazandiginda hesabindaki paranin artigini ve
  kaybettiginde paranin azaldigini gorebilmelidir

    Given kullanici tour sayfasindan login olup Casino sayfasina gidebilmeli
    When kullanici hesabina para yükleyebilmeli ve check edebilmeli
    And kullanici Casino oyununda secenekleri kontrol edebilmeli
    Then kullanici oyundan  kazanc elde ettiginde bakiyesinin arttigini ve kaybettiginde bakiyenin azaldigini gorebilmelidir


  Scenario: kullanici Lottery'de satin alabilmeli ve bakiyenin guncellendigini gormelidir

    Given kullanici tour sayfasindan login olup Lottery sayfasina gidebilmeli
    When kullanici tek bilet olarak Lottery satin alabilmeli
    Then kulllanici satin almadan sonra bakiyedeki degisimi gorebilmelidir



  Scenario: kullanici Lottery'de yeni lotteryleri ekleyebilmeli, secim yapabilmeli, satın alabilmeli ve bakiyenin guncellendigini gormelidir

    Given kullanici tour sayfasindan login olup Lottery sayfasina gidebilmeli
    When kullanici yeni lotteryler ekleyebilmeli
    And kullanici yeni lotterylere secim yapabilmeli
    And kullanici lotteryleri satin alabilmeli
    Then kulllanici satin almadan sonra bakiyedeki degisimi gorebilmelidir

















