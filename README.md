[![FollowMe](https://img.shields.io/github/followers/vladstefandieaconu?label=Follow&style=social)](https://github.com/VladStefanDieaconu)

Vlad-Stefan Dieaconu 331CA - Ianuarie 2020
Tema Limbaje formale automate, anul 3, seria CA.

<div id="top">

<!-- PROJECT SHIELDS -->
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]


<h3 align="center">Limbaje Formale si Automate (LFA)</h3>

  <p align="center">
    Anul 3, Semestrul 1, seria CA,
    <br />
    Facultatea de Automatica si Calculatoare,
    <br />
    Universitatea Politehnica Bucuresti.
  </p>
</div>


<!-- PROJECT DESCRIPTION -->
## Description :fire:

Acest repository contine codul scris de mine in timpul facultatii ca parte a materiei de Limbaje Formale si Automate.

Pentru a vedea daca graful accepta sirul vid am verificat daca starea initiala este si stare finala.
Pentru a obtine starile accesibile am facut un dfs din starea de start, toate starile visited sunt accesibile.
Pentru a obtine starile productive am construit un graf transpus (am adaugat muchie de la transitionTo la transitionFrom),
si am pornit un dfs din fiecare stare finala, marcand visited starile prin care trec. Toate starile prin care trec sunt
productive.
Algoritmii folositi pentru starile utile si pentru a afla daca limbajul este vid sau nu sunt foarte simpli, niste if-uri
folosind algoritmii de mai sus.
Nu am facut bonusul din lipsa de timp, dar ar fi trebuit doar sa fac un dfs si sa verific daca exista cicluri si sa mai
pun conditia ca toate starile sa fie utile.

### Built With :point_down:
Dezvoltat utilizand:
* [Java](https://www.java.com/en/)

<!-- LICENSE -->
## License :facepunch:

Distributed under the MIT License. See `LICENSE.txt` for more information.

<!-- CONTACT -->
## Contact :hand:
Email - vladstefandieaconu@gmail.com
<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[forks-shield]: https://img.shields.io/github/forks/VladStefanDieaconu/LFA.svg
[forks-url]: https://github.com/VladStefanDieaconu/LFA/network/members
[stars-shield]: https://img.shields.io/github/stars/VladStefanDieaconu/LFA.svg
[stars-url]: https://github.com/VladStefanDieaconu/LFA/stargazers
[license-shield]: https://img.shields.io/github/license/VladStefanDieaconu/LFA.svg
[license-url]: https://github.com/VladStefanDieaconu/LFA/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/VladStefanDieaconu

