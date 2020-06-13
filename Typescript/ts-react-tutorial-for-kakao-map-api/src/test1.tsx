import React from 'react';

const seo = require('./seoul.json');
let obj: string = '';
const test1: React.FC = () => {
  //   console.log(seo.features);
  seo.features.forEach((element: any) => {
    let name = element.properties.adm_nm.split(' ');
    console.log(name);
    for (let i = 0; i < name.length; i++) {
      if (i === 2) obj += '{\n' + "gu : '" + name[i - 1] + "',\ndong : '" + name[i] + "',\n path : [ \n";
    }
    let coor = element.geometry.coordinates;
    coor.forEach((elemen: any) => {
      let c = elemen;
      c.forEach((eleme: any) => {
        let ci = eleme;
        ci.forEach((el: any) => {
          obj += ' new window.kakao.maps.LatLng(' + el[1] + ',' + el[0] + '),\n';
        });
      });
    });
    obj += '] \n},';
  });
  console.log(obj);
  return <div></div>;
};

export default test1;
