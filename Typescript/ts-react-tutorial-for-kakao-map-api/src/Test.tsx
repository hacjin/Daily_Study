import React, { Component } from 'react';
import CSS from 'csstype';

declare var kakao: any;

const mapStyle: CSS.Properties ={
    width:'500px',
    height:'400px'
};
class Test extends Component {
    componentDidMount() {
        let container = document.getElementById('map');
      let options = {
        center: new kakao.maps.LatLng(33.450701,126.570667),
        level: 3
      };
      let map = new kakao.maps.Map(container,options);
    }
    render() {
        return (
            <div>
                <div id="map" style={mapStyle}>
                </div>
            </div>
        );
    }
}

export default Test;