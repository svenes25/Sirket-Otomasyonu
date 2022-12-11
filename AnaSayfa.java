package odev1;

import java.util.Scanner;

public class AnaSayfa {

	public static void main(String[] args) {
	
		Scanner Bilgial=new Scanner(System.in);
		System.out.println("Kaç Adet Departman Girilecektir");
		int sayi=Bilgial.nextInt();
		Departman[] Dep= new Departman[sayi];
		int no;
		int persayi;
		for (int i = 0; i < sayi; i++) {
			System.out.println("Lütfen Departman No Giriniz");
			no=Bilgial.nextInt();
			System.out.print("Lütfen Departman Adı Giriniz: ");
			String dad=Bilgial.next();
			Dep[i]= new Departman(no,dad);
		}
		for(int i=0;i<Dep.length;i++)
		{
			String depad=Dep[i].getDepAd();
			int depıd=Dep[i].getDepNo();
			System.out.println(depad+" Departmanının Personel Sayisini Giriniz");
			persayi=Bilgial.nextInt();
			Personel[] Per =new Personel[persayi];
			for (int j = 0; j < persayi; j++)
			{
				System.out.print("Lütfen Personel Adı Giriniz: ");
				String ad=Bilgial.next();
				System.out.print("Lütfen Personel Soyadı Giriniz: ");
				String soyad=Bilgial.next();
				System.out.println("Lütfen  Personel Yaşı Giriniz");
				int yas=Bilgial.nextInt();
				Per[j]=new Personel(depıd, ad, soyad, yas);
			}
			Dep[i].personeller=Per;
		}
		for(int i=0;i<Dep.length;i++)
		{
			String depad=Dep[i].getDepAd();
			int depıd=Dep[i].getDepNo();
			System.out.println(depad+" Departmanının Proje Sayisini Giriniz");
			int prosayi=Bilgial.nextInt();
			Proje[] Pro = new Proje[prosayi];
			for(int j=0;j<prosayi;j++)
			{
				System.out.println("Lütfen Proje Adı Giriniz");
				String prad=Bilgial.next();
				System.out.println("Lütfen  Proje Süresi Giriniz");
				int sure=Bilgial.nextInt();
				System.out.println("Lütfen  Proje Maliyet Giriniz");
				int maliyet=Bilgial.nextInt();
				Pro[j]=new Proje(depıd, prad, sure, maliyet);
			}
			Dep[i].projeler=Pro;
		}
		int secim=0;
		while(secim!=10)
		{
			System.out.println("1: Tüm Departmanların Bilgilerini Listele");
			System.out.println("2: Departman Adına Göre Arama Yap");
			System.out.println("3: Persomel Adına Göre Arama Yap");
			System.out.println("4: Proje Adına Göre Arama Yap");
			System.out.println("5: Yaş Bilgisine Göre Personel Bul");
			System.out.println("6: Yaş Bilgisine Göre Personel Analiz Et");
			System.out.println("7: Proje Süresine Göre Proje Bul");
			System.out.println("8: Proje Maliyetine Göre Proje Bul");
			System.out.println("9: Proje Maliyetine Göre Proje Analiz Et");
			System.out.println("10: Çıkış");
			secim=Bilgial.nextInt();
			if(secim==1)
			{
				depBilLis(Dep);
			}
			else if(secim==2)
			{
				System.out.println("Aranacak Departman Adı Giriniz");
				String Depad=Bilgial.next();
				depAdAra(Depad, Dep);
			}
			else if(secim==3)
			{
				System.out.println("Aranacak Personel Adı Giriniz");
				String Perad=Bilgial.next();
				PerAdAra(Perad,Dep);
			}
			else if(secim==4)
			{
				System.out.println("Aranacak Proje Adı Giriniz");
				String Proad=Bilgial.next();
				ProAdAra(Proad,Dep);
			}
			else if(secim==5)
			{
				System.out.println("Aranacak Yaş Bilgisini Giriniz");
				int Yas=Bilgial.nextInt();
				PerYasAra(Yas,Dep);
			}
			else if(secim==6)
			{
				PerYasAna(Dep);
			}
			else if(secim==7)
			{
				System.out.println("Aranacak Süre Bilgisini Giriniz");
				int Sure=Bilgial.nextInt();
				ProSureAra(Sure,Dep);
			}
			else if(secim==8)
			{
				System.out.println("Aranacak Maliyet Bilgisini Giriniz");
				int Mali=Bilgial.nextInt();
				ProMaliAra(Mali,Dep);
			}
			else if(secim==9)
			{
				ProMaliAna(Dep);
			}
			else if(secim==10)
			{
				System.out.println("Başarıyla Çıkış Yapılıyor");
				break;
			}
		}
	
	}
	public static void depBilLis(Departman[] Dep)
	{
		for(int i=0;i<Dep.length;i++)
		{
			System.out.println("Departman No: "+Dep[i].getDepNo()+" Departman Ad: "+Dep[i].getDepAd());
			System.out.println("Personeller:");
			Personel[] PER=Dep[i].getPersoneller();
			Proje[] PRO=Dep[i].getProjeler();
			for(int j=0;j<PER.length;j++)
			{
				System.out.println(j+1+". Personel: "+PER[j].getPerID()+" "+PER[j].getPerAd()+" "+PER[j].getPerSoyad()+" "+PER[j].getPerYas());
			}
			System.out.println("Projeler:");
			for(int j=0;j<PRO.length;j++)
			{
				System.out.println(j+1+". Proje: "+PRO[j].getProjeID()+" "+PRO[j].getProjeAd()+" "+PRO[j].getProjeSure()+" "+PRO[j].getProjeMaliyet());
			}
			System.out.println("\n");
		}
	}
	
	public static void depAdAra(String Depad,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			if(Depad.equals(Dep[i].getDepAd()))
			{
				Personel[] PER=Dep[i].getPersoneller();
				Proje[] PRO=Dep[i].getProjeler();
				for(int j=0;j<PER.length;j++)
				{
					System.out.println(j+1+". Personel: "+PER[j].getPerID()+" "+PER[j].getPerAd()+" "+PER[j].getPerSoyad()+" "+PER[j].getPerYas());
				}
				System.out.println("Projeler:");
				for(int j=0;j<PRO.length;j++)
				{
					System.out.println(j+1+". Proje: "+PRO[j].getProjeID()+" "+PRO[j].getProjeAd()+" "+PRO[j].getProjeSure()+" "+PRO[j].getProjeMaliyet());
				}
				kontrol=1;
				System.out.println("\n");
				break;
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Departman Bulunamadı");
		}
	}
	
	public static void PerAdAra(String Perad,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			Personel[] PER=Dep[i].getPersoneller();
			for(int j=0;j<PER.length;j++)
			{
				if(Perad.equals(PER[j].getPerAd()))
				{
					for(int k=0;k<Dep.length;k++)
					{
						if(PER[j].getDepNo()==Dep[k].getDepNo())
						{
							System.out.println(j+1+". Personel: "+PER[j].getPerID()+" "+PER[j].getPerAd()+" "+PER[j].getPerSoyad()+" "+PER[j].getPerYas()+" "+Dep[k].getDepAd());
							System.out.println("");
							kontrol=1;
							break;
						}
					}
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Personel Bulunamadı");
		}
	}

	public static void ProAdAra(String Proad,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			Proje[] PRO=Dep[i].getProjeler();
			for(int j=0;j<PRO.length;j++)
			{
				if(Proad.equals(PRO[j].getProjeAd()))
				{
					for(int k=0;k<Dep.length;k++)
					{
						if(PRO[j].getDepNo()==Dep[k].getDepNo())
						{
							System.out.println(j+1+". Proje: "+PRO[j].getProjeID()+" "+PRO[j].getProjeAd()+" "+PRO[j].getProjeSure()+" "+PRO[j].getProjeMaliyet()+" "+Dep[k].getDepAd());
							System.out.println("");
							kontrol=1;
							break;
						}
					}
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Proje Bulunamadı");
		}
	}
	
	public static void PerYasAra(int Yas,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			Personel[] PER=Dep[i].getPersoneller();
			for(int j=0;j<PER.length;j++)
			{
				if(PER[j].getPerYas()==Yas)
				{
					for(int k=0;k<Dep.length;k++)
					{
						if(PER[j].getDepNo()==Dep[k].getDepNo())
						{
							System.out.println(j+1+". Personel: "+PER[j].getPerID()+" "+PER[j].getPerAd()+" "+PER[j].getPerSoyad()+" "+PER[j].getPerYas()+" "+Dep[k].getDepAd());
							System.out.println("");
							kontrol=1;
							break;
						}
					}
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Personel Bulunamadı");
		}
	}
	
	public static void PerYasAna(Departman[] Dep)
	{
		int yirmi=0;
		int otuz=0;
		int kırk=0;
		int elli=0;
		int sayi=0;
		int ortalama=0;
		for(int i=0;i<Dep.length;i++)
		{
			Personel[] PER=Dep[i].getPersoneller();
			for(int j=0;j<PER.length;j++)
			{
				if(PER[j].getPerYas()<30)
				{
					yirmi++;
				}
				else if(PER[j].getPerYas()<40)
				{
					otuz++;
				}
				else if(PER[j].getPerYas()<50)
				{
					kırk++;
				}
				else
				{
					elli++;
				}
				ortalama+=PER[j].getPerYas();
				sayi++;
			}
		}
		ortalama/=sayi;
		System.out.println("30 Yaşından Küçük Personel Sayısı: "+yirmi);
		System.out.println("30-40 Yaş Arası Personel Sayısı: "+otuz);
		System.out.println("40-50 Yaşından Küçük Personel Sayısı: "+kırk);
		System.out.println("50 Yaşından Büyük Personel Sayısı: "+elli);
		System.out.println("Tüm Personellerin Yaş Ortalaması: "+ortalama);
	}
	
	public static void ProSureAra(int Sure,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			Proje[] PRO=Dep[i].getProjeler();
			for(int j=0;j<PRO.length;j++)
			{
				if(PRO[j].getProjeSure()==Sure)
				{
					System.out.println(j+1+". Proje: "+PRO[j].getProjeID()+" "+PRO[j].getProjeAd()+" "+PRO[j].getProjeSure()+" "+PRO[j].getProjeMaliyet()+" "+Dep[i].getDepAd());
					System.out.println("");
					kontrol=1;
					break;
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Proje Bulunamadı");
		}
	}
	
	public static void ProMaliAra(int Mali,Departman[] Dep)
	{
		int kontrol=0;
		for(int i=0;i<Dep.length;i++)
		{
			Proje[] PRO=Dep[i].getProjeler();
			for(int j=0;j<PRO.length;j++)
			{
				if(PRO[j].getProjeMaliyet()==Mali)
				{
					System.out.println(j+1+". Proje: "+PRO[j].getProjeID()+" "+PRO[j].getProjeAd()+" "+PRO[j].getProjeSure()+" "+PRO[j].getProjeMaliyet()+" "+Dep[i].getDepAd());
					System.out.println("");
					kontrol=1;
					break;
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("Aranan Proje Bulunamadı");
		}
	}
	
	public static void ProMaliAna(Departman[] Dep)
	{
		int max=0;
		int min=9999999;
		int sayac=0;
		int ortalama=0;
		String maxad = null;
		String minad = null;
		for(int i=0;i<Dep.length;i++)
		{
			Proje[] PRO=Dep[i].getProjeler();
			for(int j=0;j<PRO.length;j++)
			{
				if(PRO[j].getProjeMaliyet()>max)
				{
					max=PRO[j].getProjeMaliyet();
					maxad=PRO[j].getProjeAd();
				}
				if(PRO[j].getProjeMaliyet()<min)
				{
					min=PRO[j].getProjeMaliyet();
					minad=PRO[j].getProjeAd();
				}
				ortalama+=PRO[j].getProjeMaliyet();
				sayac++;
			}
		}
		ortalama/=sayac;
		System.out.println("En Yüksek Maliyetli Proje: "+maxad+": "+max);
		System.out.println("En Düşük Maliyetli Proje: "+minad+": "+min);
		System.out.println("Tüm Projlerin Ortalama Maliyetleri: "+ortalama);
	}

}